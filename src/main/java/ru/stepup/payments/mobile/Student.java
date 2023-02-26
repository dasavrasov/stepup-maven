package ru.stepup.payments.mobile;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Getter
    @Setter
    private String name;
    private List grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public List getGrades() {
        return new ArrayList<>(grades);
    }
//
//    @SneakyThrows
//    public void addGrade(int grade) {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet request = new HttpGet("http://localhost:5352/checkGrade?grade="+grade);
//        CloseableHttpResponse httpResponse = httpClient.execute(request);
//        HttpEntity entity = httpResponse.getEntity();
//        if(!Boolean.parseBoolean(EntityUtils.toString(entity))){
//            throw new IllegalArgumentException(grade + " is wrong grade");
//        }
//        grades.add(grade);
//    }

//    @SneakyThrows
//    public int raiting() {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet request = new HttpGet("http://localhost:5352/educ?sum="+grades.stream().mapToInt(x-> (int) x).sum());
//        CloseableHttpResponse httpResponse = httpClient.execute(request);
//        HttpEntity entity = httpResponse.getEntity();
//        return Integer.parseInt(EntityUtils.toString(entity));
//    }
}