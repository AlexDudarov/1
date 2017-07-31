package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.dao.TypeGoodDaoImpl;
import gmail.alexdudarkov.sportshop.model.TypeGood;
import gmail.alexdudarkov.sportshop.service.model.TypeGoodDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeGoodServiceImpl {

    private static TypeGoodServiceImpl instance = null;
    private static TypeGoodDaoImpl typeGoodDao=new TypeGoodDaoImpl();

    private TypeGoodServiceImpl() {
        // Exists only to default instantiation.
    }

    public static synchronized TypeGoodServiceImpl getInstance() {
        if (instance == null) {
            instance = new TypeGoodServiceImpl();
        }
        return instance;
    }
    public Serializable save(TypeGoodDTO typeGoodDto){
        convertDtoIntoDao(typeGoodDto);
        typeGoodDao.openCurrentSessionWithTransaction();
        Long id=(Long)typeGoodDao.save(convertDtoIntoDao(typeGoodDto));
        typeGoodDao.closeCurrentSessionWithTransaction();
        return id;
    }


    public static TypeGood convertDtoIntoDao(TypeGoodDTO typeGoodDto){
        TypeGood typeGood=new TypeGood();
        typeGood.setId(typeGoodDto.getId());
        typeGood.setName(typeGoodDto.getName());
        return typeGood;
    }

    public List<TypeGoodDTO> findAll(){
        typeGoodDao.openCurrentSessionWithTransaction();
        List<TypeGood> typeGoodList=typeGoodDao.findAll();
        List<TypeGoodDTO> typeGoodDTOList = new ArrayList<>();
        typeGoodDao.closeCurrentSessionWithTransaction();
        for(int i=0;i<typeGoodList.size();i++) {
            TypeGoodDTO brandGoodDto=new TypeGoodDTO(typeGoodList.get(i));
            typeGoodDTOList.add(brandGoodDto);
        }
        return typeGoodDTOList;
    }
}
