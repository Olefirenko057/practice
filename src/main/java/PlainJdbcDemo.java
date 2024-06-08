import dao.PlainSingerDao;
import dao.SingerDao;
import entities.Singer;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

public class PlainJdbcDemo {
    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger =
            (Logger) LoggerFactory.getLogger(PlainJdbcDemo.class);
    public static void main(String[] args) {
        logger.info("Listing initial singer data");
        listAllSingers();
        logger.info("Insert a new singer");

        Singer singer = new Singer();
        singer.setFirstName("Bob");
        singer.setLastName("Marley");
        singer.setDate(new Date(new GregorianCalendar(1990,15,10).getTime().getTime()));
        singerDao.insert(singer);

        logger.info("Listing singer data "
                + "after new singer created:");
        listAllSingers();

        logger.info("-------------");
        logger.info("Deleting the previous created singer");

        singerDao.delete(singer.getId());
        logger.info("Listing singer data "
                + "after new singer deleted:");
        listAllSingers();
    }
    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}
