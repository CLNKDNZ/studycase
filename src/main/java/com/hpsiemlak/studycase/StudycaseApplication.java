package com.hpsiemlak.studycase;

import com.hpsiemlak.studycase.models.TodoItem;
import com.hpsiemlak.studycase.models.UserRequest;
import com.hpsiemlak.studycase.repositories.TodoItemRepository;
import com.hpsiemlak.studycase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hpsiemlak.studycase.constants.AppConstants.ADMIN;
import static com.hpsiemlak.studycase.constants.AppConstants.USER;

@SpringBootApplication
public class StudycaseApplication {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(StudycaseApplication.class, args);
    }

    @PostConstruct
    public void initUserRepo() {
        UserRequest usr = new UserRequest();
        usr.setPassword("deniz123");
        usr.setRole(ADMIN);
        usr.setUsername("dnzcelenk");
        userService.saveUsername(usr);

        UserRequest usrRoleuser = new UserRequest();
        usr.setPassword("deniz123+-");
        usr.setRole(USER);
        usr.setUsername("clnkDeniz");
        userService.saveUsername(usr);

        todoItemRepository.saveAll(Stream.of(new TodoItem("Ara", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Mail Gönder", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Toplantıya Katıl", "Açıklama", "Weekly", "Deniz"),
                new TodoItem("Evi Ara", "Açıklama", "Diğer", "Deniz"),
                new TodoItem("Kargoyu Teslim Al", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Efor Gir", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Rapor Hazırla", "Açıklama", "Weekly", "Deniz"),
                new TodoItem("Evi Ara", "Açıklama", "Diğer", "Deniz"),
                new TodoItem("İşi tamamla", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Mail Gönder", "Açıklama", "Daily", "Deniz"),
                new TodoItem("Toplantıya Katıl", "Açıklama", "Weekly", "Deniz"),
                new TodoItem("Evi Ara", "Açıklama", "Diğer", "Deniz")).collect(Collectors.toList()));


    }
}
