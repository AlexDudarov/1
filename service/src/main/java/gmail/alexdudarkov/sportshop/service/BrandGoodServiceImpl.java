package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.dao.BrandGoodDaoImpl;
import gmail.alexdudarkov.sportshop.model.BrandGood;
import gmail.alexdudarkov.sportshop.service.model.BrandGoodDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrandGoodServiceImpl {
    private static BrandGoodServiceImpl instance = null;
    private static BrandGoodDaoImpl brandGoodDao=new BrandGoodDaoImpl();

    private BrandGoodServiceImpl() {
        // Exists only to default instantiation.
    }

    public static synchronized BrandGoodServiceImpl getInstance() {
        if (instance == null) {
            instance = new BrandGoodServiceImpl();
        }
        return instance;
    }
    public Serializable save(BrandGoodDTO brandGoodDto){
        brandGoodDao.openCurrentSessionWithTransaction();
        Long id=(Long)brandGoodDao.save(convertDtoIntoDao(brandGoodDto));
        brandGoodDao.closeCurrentSessionWithTransaction();
        return id;
    }

    public static BrandGood convertDtoIntoDao(BrandGoodDTO brandGoodDto){
        BrandGood brandGood=new BrandGood();
        brandGood.setId(brandGoodDto.getId());
        brandGood.setName(brandGoodDto.getName());
        return brandGood;
    }

    public List<BrandGoodDTO> findAll(){
        brandGoodDao.openCurrentSessionWithTransaction();
        List<BrandGood> brandGoodList=brandGoodDao.findAll();
        List<BrandGoodDTO> brandGoodDTOList = new ArrayList<>();
        brandGoodDao.closeCurrentSessionWithTransaction();
        for(int i=0;i<brandGoodList.size();i++) {
           BrandGoodDTO brandGoodDto=new BrandGoodDTO(brandGoodList.get(i));
           brandGoodDTOList.add(brandGoodDto);
        }
        return brandGoodDTOList;
    }
}
