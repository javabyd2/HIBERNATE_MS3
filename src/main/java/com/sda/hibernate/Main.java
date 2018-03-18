package com.sda.hibernate;

import com.sda.hibernate.entity.BookEntity;
import com.sda.hibernate.entity.Car;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.entity.ShopEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class Main {


    private static final SessionFactory sessionFactory;

    static {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();              // odwoluje sie do pliku configuracyjnego
            sessionFactory = configuration.buildSessionFactory(); //  tworzymy sesion factory z obiektu Configurattion / zbuduje to sesje/ build.sessionFactory zwraca sessionFactory
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);   // wurzuca go build session factory jesli nie uda sie zrobic tej sessji
        }
    }

    public static Session getSession() throws HibernateException {       // metoda pobiera sesje z sessionFactory
        return sessionFactory.openSession();
    }


    public static void main(String[] args) {

        BookEntity bookEntity = new BookEntity();                     //
        bookEntity.setAuthor("Jan Kowalski");
        bookEntity.setTitle("Programowanie dla dzieci");
        bookEntity.setIsbn("7655");

        Transaction tx = null;
        Session session = getSession();    // pobieramy z gory z getSession

        tx = session.beginTransaction();  //otwieram transakcje
        session.save(bookEntity);
        tx.commit();                        // zamykam transakcje


        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setAuthor("C.Andersen");
        bookEntity1.setTitle("Love story");
        bookEntity1.setIsbn("39982");
        bookEntity1.setCategory("Tale");
        bookEntity1.setOnStock(5);
        bookEntity1.setPrice(BigDecimal.valueOf(45.7).setScale(2));
        bookEntity1.setPageCount(199);

//        tx = session.beginTransaction();
//        session.save(bookEntity1);
//        tx.commit();


        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setAuthor("Ferrit");
        bookEntity2.setPrice(BigDecimal.valueOf(40.8).setScale(2));
        bookEntity2.setIsbn("666666");
        bookEntity2.setCategory("Comedy");
        bookEntity2.setOnStock(1);
        bookEntity2.setTitle("Spring");

//        tx = session.beginTransaction();
//        session.save(bookEntity2);
//        tx.commit();


        BookEntity bookEntity3 = new BookEntity();
        bookEntity3.setAuthor("Kolanowski");
        bookEntity3.setPrice(BigDecimal.valueOf(88.8).setScale(2));
        bookEntity3.setIsbn("1298");
        bookEntity3.setCategory("Comedy");
        bookEntity3.setOnStock(3);
        bookEntity3.setTitle("Return home");

        BookEntity bookEntity4 = new BookEntity();
        bookEntity4.setAuthor("Swiderowski");
        bookEntity4.setPrice(BigDecimal.valueOf(21.8).setScale(2));
        bookEntity4.setIsbn("5555");
        bookEntity4.setCategory("Comedy");
        bookEntity4.setOnStock(2);
        bookEntity4.setTitle("Holiday");

        tx = session.beginTransaction();
        session.save(bookEntity1);
        session.save(bookEntity2);
        session.save(bookEntity3);
        session.save(bookEntity4);
        tx.commit();


        List<BookEntity>bookEntityList = session.createCriteria(BookEntity.class).list();  // zczytywanie danych z tabeli

        for(BookEntity date : bookEntityList){
            System.out.println("autor: "+date.getAuthor());
            System.out.println("title: "+date.getTitle());
            System.out.println("category:"+date.getCategory());
        }


        System.out.println();
        List<BookEntity>bookEntityList1
                = session.createQuery("FROM "+BookEntity.class.getName()).list();  // drugi sposob

        for(BookEntity date : bookEntityList1){
            System.out.println("autor: "+date.getAuthor());
            System.out.println("title: "+date.getTitle());
            System.out.println("category:"+date.getCategory());
        }


        Category category = new Category();
        category.setName("Marek");
        Category category1 = new Category();
        category1.setName("Maciej");
        Category category2 = new Category();
        category2.setName("Kasia");

        tx = session.beginTransaction();
        session.save(category);
        session.save(category1);
        session.save(category2);
        tx.commit();

        List<Category>categoryList = session.createCriteria(Category.class).list();

        for(Category cat:categoryList){
            System.out.println("id: "+cat.getId());
            System.out.println("name: "+cat.getName());
        }


        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setName("Casio");
        shopEntity.setEstablishment("2010-02-01");
        shopEntity.setIndustry("watches");
        shopEntity.setStaff(15);

        ShopEntity shopEntity1 = new ShopEntity();
        shopEntity1.setName("Garmin");
        shopEntity1.setStaff(22);
        shopEntity1.setIndustry("GPS-Devices");
        shopEntity1.setEstablishment("2009");

        ShopEntity shopEntity2 = new ShopEntity();
        shopEntity2.setEstablishment("1999-12-30");
        shopEntity2.setIndustry("Bicycles");
        shopEntity2.setName("Super-bike");
        shopEntity2.setStaff(10);


        tx = session.beginTransaction();
        session.save(shopEntity);
        session.save(shopEntity1);
        session.save(shopEntity2);
        tx.commit();




        List<ShopEntity>shopEntityList = session.createQuery("From "+ShopEntity.class.getName()).list();


        for(ShopEntity shop:shopEntityList){
            System.out.println(shop.getId());
            System.out.println(shop.getName());
            System.out.println(shop.getIndustry());
            System.out.println(shop.getEstablishment());
        }


        System.out.println();


        List<ShopEntity>shopEntityList1=session.createCriteria(ShopEntity.class).list();

        for(ShopEntity shopE:shopEntityList1){
            System.out.println("Id: "+shopE.getId());
            System.out.println("Name: "+shopE.getName());
            System.out.println("Industry: "+shopE.getIndustry());
            System.out.println("Establishment: "+shopE.getEstablishment());

        }




        Car car = new Car();
        car.setMark("Fiacior");
        car.setModel("127p");
        car.setReg_number("SD 87888");
        car.setRate(3);


        Car car1 = new Car();
        car1.setRate(33);
        car1.setReg_number("WW 899999");
        car1.setMark("Super_Ferrarri");
        car1.setModel("SPIDER");

        tx = session.beginTransaction();
        session.save(car);
        session.save(car1);
        tx.commit();

        //List<Car>carList=session.createQuery("From "+Car.class.getName()).list();
        List<Car>carList = session.createCriteria(Car.class).list();

        System.out.println();

        for(Car carMy: carList){
            System.out.println("reg number: "+carMy.getReg_number());
            System.out.println("mark: "+carMy.getMark());
            System.out.println("model: "+carMy.getModel());
            System.out.println("rate: "+carMy.getRate());
        }


    }
}
