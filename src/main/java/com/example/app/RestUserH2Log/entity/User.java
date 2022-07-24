package com.example.app.RestUserH2Log.entity;

import javax.persistence.*;

// Модель объекта.
// Каждый @Entity подбирается Hibernate,
// для него создается таблица, поля сопоставляются,
// и он становится управляемым объектом для настроенной
// вами базы данных.
// @Entity - в основном таблица, экземпляр сущности
// соответствует строке таблицы.
@Entity
@Table(name = "users")
public class User {

    // Чтобы аннотировать поле как идентификатор объекта,
    // используете аннотацию @Id, и она будет установлена
    // как автоинкрементный первичный ключ таблицы.
    // Кроме того, можете дополнительно указать, что это
    // @GeneratedValue, и установить для GenerationType
    // значение AUTO.
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // сообщает Hibernate, как генерируется идентификатор.
    // Настраивает автоматическое увеличение значения
    // идентификатора.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
