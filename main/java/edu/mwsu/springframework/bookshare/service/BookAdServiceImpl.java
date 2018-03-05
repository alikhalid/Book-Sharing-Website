package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class BookAdServiceImpl implements BookAdService {

    //use hash map to act as a db
    private Map<Integer, BookAd> bookAds;

    //bootstrap some data initial data
    private void loadBooks(){

        this.bookAds = new HashMap<>();

        BookAd bookAd1 = new BookAd();
        bookAd1.setId(1);
        bookAd1.setDescription("The Larson CALCULUS program has a long history of innovation in the calculus market. It has been widely praised by a generation of students and professors for its solid and effective pedagogy that addresses the needs of a broad range of teaching and learning styles and environments. Each title is just one component in a comprehensive calculus course program that carefully integrates and coordinates print, media, and technology products for successful teaching and learning.");
        bookAd1.setPrice(12.99);
        bookAd1.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51IBi5Fx5oL._SX387_BO1,204,203,200_.jpg");
        bookAd1.setTitle("Calculus");
        bookAd1.setAuthor("Ron Larson");
        bookAd1.setISBN("978-1285057095");
        bookAd1.setEdition("10th Edition");
        bookAd1.setGenre("Math");
        bookAd1.setType("Hardcover");
        bookAd1.setCourseNum("MATH 1634");
        bookAd1.setCourseName("Calculus 1");
        bookAd1.setEmail("AKhal322@rocketmail.com");
        bookAd1.setBuy(true);
        bookAd1.setRent(false);
        bookAd1.setFree(false);
        bookAd1.setCondition("Like New");
        bookAd1.setPublisher("Brooks Cole");
        bookAd1.setHashKey("L33T");
        bookAd1.setPhoneNumber("808-080-8080");
        bookAd1.setUserName("AKhal322");


        bookAds.put(1, bookAd1);

        BookAd bookAd2 = new BookAd();
        bookAd2.setId(2);
        bookAd2.setDescription("I have a cat. His name is Paul.");
        bookAd2.setPrice(12.99);
        bookAd2.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51l3ucqW6nL._SX402_BO1,204,203,200_.jpg");
        bookAd2.setTitle("Object-Oriented Software Engineering");
        bookAd2.setAuthor("David C. Kung Dr.");
        bookAd2.setISBN("978-0073376257");
        bookAd2.setEdition("1st Edition");
        bookAd2.setGenre("Computer Science");
        bookAd2.setType("Hardcover");
        bookAd2.setCourseNum("CMPS 8654");
        bookAd2.setCourseName("Software Engineering");
        bookAd2.setEmail("AKhal322@rocketmail.com");
        bookAd2.setBuy(true);
        bookAd2.setRent(false);
        bookAd2.setFree(false);
        bookAd2.setCondition("Like New");
        bookAd2.setPublisher("McGraw-Hill Education");
        bookAd2.setHashKey("L33T");
        bookAd2.setPhoneNumber("808-080-8080");
        bookAd2.setUserName("AKhal322");


        bookAds.put(2, bookAd2);

        BookAd bookAd3 = new BookAd();
        bookAd3.setId(3);
        bookAd3.setDescription("BookAd 1");
        bookAd3.setPrice(12.99);
        bookAd3.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41UWC4kbxGL._SX414_BO1,204,203,200_.jpg");
        bookAd3.setTitle("Campbell Biology");
        bookAd3.setAuthor("Jane B. Reece");
        bookAd3.setISBN("978-0321558237");
        bookAd3.setEdition("9th Edition");
        bookAd3.setGenre("Natural Sciences");
        bookAd3.setType("Hardcover");
        bookAd3.setCourseNum("BIO 1234");
        bookAd3.setCourseName("Biology 1");
        bookAd3.setEmail("AKhal322@rocketmail.com");
        bookAd3.setBuy(true);
        bookAd3.setRent(false);
        bookAd3.setFree(false);
        bookAd3.setCondition("Like New");
        bookAd3.setPublisher("Benjamin Cummings");
        bookAd3.setHashKey("L33T");
        bookAd3.setPhoneNumber("808-080-8080");
        bookAd3.setUserName("AKhal322");


        bookAds.put(3, bookAd3);

        BookAd bookAd4 = new BookAd();
        bookAd4.setId(4);
        bookAd4.setDescription("Understanding Business has long been the market leader because we listen to instructors and students. With this eleventh edition we are proud to offer a platinum experience, that:\n" +
                "\n" +
                "Improves Student Performance―Understanding Business puts students at the center. It’s the only learning program on the market to offer proven adaptive technology that increases grades by a full letter through Connect® Business, and the only program to offer the first and only adaptive eBook ever, SmartBook.\n" +
                "\n" +
                "Enhances your Teaching―The authors are dedicated to supporting your teaching and your student’s learning, which is why they listen to YOU and develop resources based on YOUR suggestions and course needs. This is the only author team on the market that carefully reviews each and every resource to ensure cohesion. \n" +
                "\n" +
                "Accessible to All―This learning program has moved toward tighter compliance with the Web Content Accessibility Guidelines, and provides students the opportunity to learn regardless of learning style or disability. What’s more, it earned a perfect score of 100 points possible by Quality Matters, an independent organization that reviews and certifies the quality of online courses and online components. ");
        bookAd4.setPrice(12.99);
        bookAd4.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41gH8BAcR0L._SX389_BO1,204,203,200_.jpg");
        bookAd4.setTitle("Understanding Business");
        bookAd4.setAuthor("William G Nickels");
        bookAd4.setISBN("978-0078023163");
        bookAd4.setEdition("11th Edition");
        bookAd4.setGenre("Business");
        bookAd4.setType("Hardcover");
        bookAd4.setCourseNum("BIS 2461");
        bookAd4.setCourseName("Fondations of Business");
        bookAd4.setEmail("AKhal322@rocketmail.com");
        bookAd4.setBuy(true);
        bookAd4.setRent(false);
        bookAd4.setFree(false);
        bookAd4.setCondition("Like New");
        bookAd4.setPublisher("McGraw-Hill Education");
        bookAd4.setHashKey("L33T");
        bookAd4.setPhoneNumber("808-080-8080");
        bookAd4.setUserName("AKhal322");


        bookAds.put(4, bookAd4);

        BookAd bookAd5 = new BookAd();
        bookAd5.setId(5);
        bookAd5.setDescription("I once cooked and ate my shoe.");
        bookAd5.setPrice(12.99);
        bookAd5.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/51OOdInnHWL._SX389_BO1,204,203,200_.jpg");
        bookAd5.setTitle("Basic English");
        bookAd5.setAuthor("Julie Lachance");
        bookAd5.setISBN("978-0071849623");
        bookAd5.setEdition("2nd Edition");
        bookAd5.setGenre("English");
        bookAd5.setType("Paperback");
        bookAd5.setCourseNum("ENG 1111");
        bookAd5.setCourseName("Learn English 101");
        bookAd5.setEmail("AKhal322@rocketmail.com");
        bookAd5.setBuy(true);
        bookAd5.setRent(false);
        bookAd5.setFree(false);
        bookAd5.setCondition("Like New");
        bookAd5.setPublisher("McGraw-Hill Education");
        bookAd5.setHashKey("L33T");
        bookAd5.setPhoneNumber("808-080-8080");
        bookAd5.setUserName("AKhal322");


        bookAds.put(5, bookAd5);

        BookAd bookAd6 = new BookAd();
        bookAd6.setId(6);
        bookAd6.setDescription("Thermodynamics, An Engineering Approach, eighth edition, covers the basic principles of thermodynamics while presenting a wealth of real-world engineering examples so students get a feel for how thermodynamics is applied in engineering practice. This text helps students develop an intuitive understanding by emphasizing the physics and physical arguments. Cengel and Boles explore the various facets of thermodynamics through careful explanations of concepts and use of numerous practical examples and figures, having students develop necessary skills to bridge the gap between knowledge and the confidence to properly apply their knowledge.");
        bookAd6.setPrice(12.99);
        bookAd6.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/5122xXTVPZL._SX395_BO1,204,203,200_.jpg");
        bookAd6.setTitle("Thermodynamics: An Engineering Approach");
        bookAd6.setAuthor("Yunus A. Cengel & Michael A. Boles");
        bookAd6.setISBN("978-0073398174");
        bookAd6.setEdition("8th Edition");
        bookAd6.setGenre("Engineering");
        bookAd6.setType("Hardcover");
        bookAd6.setCourseNum("ENGI 2555");
        bookAd6.setCourseName("Thermodynamics");
        bookAd6.setEmail("AKhal322@rocketmail.com");
        bookAd6.setBuy(true);
        bookAd6.setRent(false);
        bookAd6.setFree(false);
        bookAd6.setCondition("Like New");
        bookAd6.setPublisher("McGraw-Hill Education");
        bookAd6.setHashKey("L33T");
        bookAd6.setPhoneNumber("808-080-8080");
        bookAd6.setUserName("AKhal322");


        bookAds.put(6, bookAd6);
    }

    public BookAdServiceImpl() {
        loadBooks();
    }

    @Override
    public List<BookAd> listBooks(String filter, String searchBy) {

        if(searchBy.equals("")) {
            if (filter.equals("all")) {
                return new ArrayList<>(bookAds.values());
            } else {
                ArrayList<BookAd> filteredAds = new ArrayList<>();
                for (Map.Entry<Integer, BookAd> ad : bookAds.entrySet()) {
                    if (ad.getValue().getGenre().equals(filter))
                        filteredAds.add(ad.getValue());
                }
                return filteredAds;
            }
        }
        else{
            ArrayList<BookAd> filteredAds = new ArrayList<>();
            for (Map.Entry<Integer, BookAd> ad : bookAds.entrySet()) {
                if (ad.getValue().getCourseName().toLowerCase().contains(searchBy.toLowerCase()) ||
                        ad.getValue().getAuthor().toLowerCase().contains(searchBy.toLowerCase()) ||
                        ad.getValue().getGenre().toLowerCase().contains(searchBy.toLowerCase()) ||
                        ad.getValue().getTitle().toLowerCase().contains(searchBy.toLowerCase()) ||
                        ad.getValue().getUserName().toLowerCase().contains(searchBy.toLowerCase()))
                    filteredAds.add(ad.getValue());
            }
            return filteredAds;
        }
    }

    @Override
    public void delete(Integer id){ bookAds.remove(id); }

    @Override
    public BookAd getBookById(Integer id) {
        return bookAds.get(id);
    }

    @Override
    public BookAd saveOrUpdate(BookAd bookAd) {

        if(bookAd != null){
            if(bookAd.getId() != null){//this is update

            }else{//this is new
                bookAd.setId(getNextKey());
            }
            bookAds.put(bookAd.getId(), bookAd);//save it in hash map
        }else{
            throw new RuntimeException("Cannot create bookAd!");
        }

        return bookAd;
    }

    private Integer getNextKey(){
        if (bookAds.size() == 0)
            return 1;
        return Collections.max(bookAds.keySet()) + 1;
    }
}
