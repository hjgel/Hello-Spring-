package Hyunjun.hellospring.domain;

public class Member {

    private Long id; // 운영자가 임의로 줌
    private String name; // 회원가입할 때 적음.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
