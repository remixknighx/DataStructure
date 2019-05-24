package com;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TestSort {

    public static void main(String[] args) {
        // roe 3.00-4.00
        // beginDate 2017-10-10 09:00:00

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Fund> fundList = new ArrayList<>();
        Fund fund1 = new Fund();
        fund1.setBeginDate("2017-10-10 09:00:00");
        fund1.setRoe("3.00-4.00");
        fundList.add(fund1);
        Fund fund2 = new Fund();
        fund2.setBeginDate("2017-10-10 08:00:00");
        fund2.setRoe("6.00-12.00");
        fundList.add(fund2);
        Fund fund3 = new Fund();
        fund3.setBeginDate("2017-10-10 08:00:00");
        fund3.setRoe("5.00");
        fundList.add(fund3);
        // 先按beginDate进行倒序排序，再按roe进行倒序排序
        fundList.sort(Comparator.comparing(new Function<Fund, Long>() {
            @Override
            public Long apply(Fund fund) {
                try {
                    return sdf.parse(fund.getBeginDate()).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }).reversed().thenComparing(new Function<Fund, BigDecimal>() {
            @Override
            public BigDecimal apply(Fund s) {
                return new BigDecimal(s.getRoe().split("-")[0]);
            }
        }).reversed());

        System.out.println(fundList);
    }

}

class Fund{
    private String roe;
    private String beginDate;

    public String getRoe() {
        return roe;
    }

    public void setRoe(String roe) {
        this.roe = roe;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "roe='" + roe + '\'' +
                ", beginDate='" + beginDate + '\'' +
                '}';
    }
}

