package vn.tuanflutte.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.tuanflutte.entities.Category;
import vn.tuanflutte.entities.Coupon;
import vn.tuanflutte.repositories.CategoryRepository;

@Configuration
public class Database {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Category category1 = new Category("ÁO KHOÁC", 1);
//                Category category2 = new Category("ÁO THUN", 1);
//                Category category3 = new Category("ÁO POLO", 1);
//                Category category4 = new Category("ÁO SƠ MI", 1);
//                Category category5 = new Category("ÁO CHUI ĐẦU/ HOODIE", 1);
//                Category category6 = new Category("QUẦN JOGGER", 1);
//                Category category7 = new Category("QUẦN SHORTS", 1);
//                Category category8 = new Category("QUẦN DÀI NỮ", 1);
//                Category category9 = new Category("VÁY", 1);
//                Category category10 = new Category("GIÀY DÉP", 1);
//                Category category11 = new Category("TÚI VÍ", 1);
//                Category category12 = new Category("MŨ NÓN", 1);
//
//                logger.info("insert data: "+categoryRepository.save(category1));
//                logger.info("insert data: "+categoryRepository.save(category2));
//                logger.info("insert data: "+categoryRepository.save(category3));
//                logger.info("insert data: "+categoryRepository.save(category4));
//                logger.info("insert data: "+categoryRepository.save(category5));
//                logger.info("insert data: "+categoryRepository.save(category6));
//                logger.info("insert data: "+categoryRepository.save(category7));
//                logger.info("insert data: "+categoryRepository.save(category8));
//                logger.info("insert data: "+categoryRepository.save(category9));
//                logger.info("insert data: "+categoryRepository.save(category10));
//                logger.info("insert data: "+categoryRepository.save(category11));
//                logger.info("insert data: "+categoryRepository.save(category12));
            }
        };
    }


}
