package com.example.ex3;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {

    private ObservableList<Week> data = null;

    @FXML
    TableView tableView;
    @FXML
    TableColumn monthYear;
    @FXML
    TextField month;
    @FXML
    TextField year;
    @FXML
    Label date;

    @FXML
    public void initialize(){
        LocalDate todaydate = LocalDate.now();
        int monthNow = todaydate.getMonthValue();
        int yearNow = todaydate.getYear();

        month.setText(todaydate.getMonthValue() + "");
        year.setText(todaydate.getYear() + "");

        makeItems(monthNow, yearNow);
    }

    public void makeItems(int month, int year){
        LocalDate date = LocalDate.of(year, month, 1);
        int monthLength = date.lengthOfMonth();
        int startDay = date.getDayOfWeek().getValue() % 7 + 1;

        tableView.getItems().clear();
        data = FXCollections.observableList(createWeeks(startDay, monthLength));
        tableView.setItems(data);

        monthYear.setText(date.getMonth().name() + " " + year);
    }

    private int[] setDays(int startDay, int start, int end){
        int[] days = new int[7];

        for(int i = 1, j = 0; i <= 7; i++){
            if(i >= startDay && j + start <= end)
                days[i - 1] = j++ + start;
            else
                days[i - 1] = 0;
            System.out.print(days[i -1] + " ");
        }
        System.out.println();

        return days;
    }

    private List<Week> createWeeks(int startDay, int lengthMonth){
        System.out.println(startDay + ", " + lengthMonth);
        List<Week> weeks = new ArrayList<Week>();
        weeks.add(new Week(setDays(startDay, 1, 1 + 7 - startDay)));
        weeks.add(new Week(setDays(1, 2 + 7 - startDay,  1 + 7 * 2 - startDay)));
        weeks.add(new Week(setDays(1, 2 + 7 * 2 - startDay,  1 + 7 * 3 - startDay)));
        weeks.add(new Week(setDays(1, 2 + 7 * 3 - startDay,  1 + 7 * 4 - startDay)));
        if(1 + 7 * 5 - startDay > lengthMonth){
            weeks.add(new Week(setDays(1, 2 + 7 * 4 - startDay, lengthMonth)));
            return weeks;
        }
        weeks.add(new Week(setDays(1, 2 + 7 * 4 - startDay, 1 + 7 * 5 - startDay)));
        weeks.add(new Week(setDays(1, 2 + 7 * 5 - startDay, lengthMonth)));
        for (Week week: weeks) System.out.println(week.toString());
        return weeks;

    }

    public void changeCalendar(){
        try {
            int month = Integer.valueOf(this.month.getText().trim());
            int year = Integer.valueOf(this.year.getText().trim());

            makeItems(month, year);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
