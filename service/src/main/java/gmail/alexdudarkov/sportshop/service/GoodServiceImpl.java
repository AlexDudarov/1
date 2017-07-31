package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.dao.GoodDaoImpl;
import gmail.alexdudarkov.sportshop.model.Good;
import gmail.alexdudarkov.sportshop.service.model.GoodDTO;

import java.io.Serializable;

/**
 * Created by User-PC on 27.07.2017.
 */
public class GoodServiceImpl {

    private static GoodServiceImpl instance = null;
    private static GoodDaoImpl goodDao=new GoodDaoImpl();

    private GoodServiceImpl() {
        // Exists only to default instantiation.
    }

    public static synchronized GoodServiceImpl getInstance() {
        if (instance == null) {
            instance = new GoodServiceImpl();
        }
        return instance;
    }
    public Serializable save(GoodDTO goodDto){

        goodDao.openCurrentSessionWithTransaction();
        Long id=(Long)goodDao.save(convertDtoIntoDao(goodDto));
        goodDao.closeCurrentSessionWithTransaction();
        return id;
    }


    public static Good convertDtoIntoDao(GoodDTO goodDto){
        Good good=new Good();
        good.setId(goodDto.getId());
        good.setAvailability(goodDto.getAvailability());
        good.setIconPath(goodDto.getIconPath());
        good.setModel(goodDto.getModel());
        good.setPrice(goodDto.getPrice());
        good.setBrandGood(BrandGoodServiceImpl.convertDtoIntoDao(goodDto.getBrandGoodDto()));
        good.setTypeGood(TypeGoodServiceImpl.convertDtoIntoDao(goodDto.getTypeGoodDto()));
        return good;
    }
}
