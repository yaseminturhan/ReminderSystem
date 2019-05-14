package implementation;

import constant.InterestPeriod;
import interfaces.IDao;
import pojo.TimeDeposit;
import statics.Global;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeDepositDaoImplementation extends FileProcess implements IDao<TimeDeposit> {

    private static final String FILE_NAME= "time_deposit.txt";

    @Override
    public void save(TimeDeposit timeDeposit, String id) {

    }

    @Override
    public void save(TimeDeposit timeDeposit) {
        timeDeposit.setId(super.getLastId(FILE_NAME));
        timeDeposit.setDate(new Date().toString());
        super.writeFile(FILE_NAME, timeDeposit.toString());
    }

    @Override
    public void update(String id, TimeDeposit timeDeposit) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<TimeDeposit> getAll() {
        ArrayList<TimeDeposit> timeDeposits = new ArrayList<>();
        for (String line : super.readLines(FILE_NAME)) {
            String[] attr = line.split("___");
            InterestPeriod interestPeriod =
                    attr[4].equals("DAILY") ? InterestPeriod.DAILY :
                    attr[4].equals("MONTHLY") ? InterestPeriod.MONTHLY : InterestPeriod.ANNUAL;
            TimeDeposit timeDeposit = new TimeDeposit(
                    Double.parseDouble(attr[2]),
                    Double.valueOf(attr[3]),
                    interestPeriod,
                    attr[5]
                    );
            timeDeposit.setDate(attr[1]);
            timeDeposits.add(timeDeposit);
        }
        return timeDeposits;
    }

    public ArrayList<ArrayList<String>> getAllForTable() {
        ArrayList<ArrayList<String>> datas = new ArrayList<>();
        for(TimeDeposit timeDeposit : this.getAll()) {
            if (timeDeposit.getUsername().equals(Global.user.getUsername())) {
                ArrayList<String> data = new ArrayList<>();
                data.add(String.valueOf(timeDeposit.getBalance()));
                data.add(String.valueOf(timeDeposit.getBalance()));
                data.add(timeDeposit.getInterestPeriod().name());
                data.add(timeDeposit.getDate());
                double currentval = timeDeposit.getBalance() + (timeDeposit.getInterest() * timeDeposit.getBalance() / 100.0 );
                data.add(String.valueOf(currentval));
                datas.add(data);
            }
        }
        return datas;
    }

    public ArrayList<String> getColumnsForTable() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Balance");
        columns.add("Interest");
        columns.add("Interest Period");
        columns.add("Date");
        columns.add("Current Value");
        return columns;
    }
}































