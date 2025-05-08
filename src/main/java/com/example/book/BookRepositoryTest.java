package com.example.book;

import com.example.book.entity.Book;
import com.example.springdi.SpringDiProjectApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringDiProjectApplication.class)  // ✅ 명시적 설정 추가
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("도서 등록 테스트")
    void testCreateBook() {
        Book book = Book.builder()
                .title("스프링 부트 입문")
                .author("홍길동")
                .isbn("9788956746425")
                .price(30000)
                .publishDate(LocalDate.of(2025, 5, 7))
                .build();

        Book savedBook = bookRepository.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("스프링 부트 입문");
    }

    @Test
    @DisplayName("ISBN으로 도서 조회 테스트")
    void testFindByIsbn() {
        Book book = Book.builder()
                .title("JPA 프로그래밍")
                .author("박둘리")
                .isbn("9788956746432")
                .price(35000)
                .publishDate(LocalDate.of(2025, 4, 30))
                .build();

        bookRepository.save(book);

        Book found = bookRepository.findByIsbn("9788956746432");

        assertThat(found).isNotNull();
        assertThat(found.getAuthor()).isEqualTo("박둘리");
    }

    @Test
    @DisplayName("저자명으로 도서 목록 조회 테스트")
    void testFindByAuthor() {
        Book book1 = Book.builder().title("책1").author("홍길동").isbn("111").price(10000).publishDate(LocalDate.now()).build();
        Book book2 = Book.builder().title("책2").author("홍길동").isbn("222").price(15000).publishDate(LocalDate.now()).build();
        bookRepository.saveAll(List.of(book1, book2));

        List<Book> books = bookRepository.findByAuthor("홍길동");

        assertThat(books).hasSize(2);
    }

    @Test
    @DisplayName("도서 정보 수정 테스트")
    void testUpdateBook() {
        Book book = Book.builder().title("기존 제목").author("저자").isbn("333").price(10000).publishDate(LocalDate.now()).build();
        Book saved = bookRepository.save(book);

        saved.setTitle("수정된 제목");
        Book updated = bookRepository.save(saved);

        assertThat(updated.getTitle()).isEqualTo("수정된 제목");
    }

    @Test
    @DisplayName("도서 삭제 테스트")
    void testDeleteBook() {
        Book book = Book.builder().title("삭제할 책").author("저자").isbn("444").price(20000).publishDate(LocalDate.now()).build();
        Book saved = bookRepository.save(book);

        bookRepository.deleteById(saved.getId());

        Optional<Book> result = bookRepository.findById(saved.getId());
        assertThat(result).isEmpty();
    }
}