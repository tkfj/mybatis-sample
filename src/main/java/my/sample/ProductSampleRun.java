package my.sample;

import my.sample.domain.model.Book;
import my.sample.domain.model.BookShelf;
import my.sample.domain.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductSampleRun {

    public static void main(String[] args) {
        ProductSampleRun productSampleRun = new ProductSampleRun();
        productSampleRun.execute();
    }

    public void execute() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        ProductService productService = ctx.getBean(ProductService.class);
        BookShelf bookShelf = productService.getBookShelf("0000000001");

        System.out.println("BookShelf [id= " + bookShelf.getShelfId());
        for (Book b : bookShelf.getBooks()) {
            System.out.println("  Book [isbn= " + b.getIsbn() + " title= "
                + b.getTitle() + " author= " + b.getAuthor()
                + " publisher= " + b.getPublisher() + " ]");

        }
        System.out.println("]");

        System.out.println(productService.getBookShelf2("isbn0000000006"));
        System.out.println(productService.getBookShelves("0000000002"));

    }
}
