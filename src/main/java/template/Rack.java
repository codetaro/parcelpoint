package template;

import java.util.*;

public class Rack {
    private String[][] columns;
    private int colNum;
    private int boxNum;

    public Rack(int colNum, int boxNum) {
        this.colNum = colNum;
        this.boxNum = boxNum;
        this.columns = new String[colNum][boxNum];
    }

    public String getColumnName(int colIdx) {
        // the code point of 'A' is 65
        return String.valueOf(Character.toChars(colIdx + 65));
    }

    public boolean isColumnFull(int colIdx) {
        return (columns[colIdx][boxNum - 1] == null) ? false : true;
    }


    public Map<String, List> getCurrentState() {
        Map<String, List> state = new HashMap<String, List>();
        for (int i = 0; i < colNum; i++) {

            List<String> loads = new ArrayList<>(Arrays.asList(columns[i]));
            loads.removeIf(Objects::isNull);
            state.put(getColumnName(i), loads);
        }
        return state;
    }

    public boolean onload(int colIdx, String load) {
        int boxIdx = getEmptyBoxIdx(colIdx);
        if (boxIdx != -1) {
            columns[colIdx][boxIdx] = load;
            return true;
        } else {
            return false;
        }
    }

    private int getEmptyBoxIdx(int colIdx) {
        for (int j = 0; j < boxNum; j++) {
            if (columns[colIdx][j] == null || columns[colIdx][j].isEmpty())
                return j;
        }
        return -1;
    }

    public int getColNum() {
        return colNum;
    }

    public int getBoxNum() {
        return boxNum;
    }
}
