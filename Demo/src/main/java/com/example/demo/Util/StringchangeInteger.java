package com.example.demo.Util;

public class StringchangeInteger {
    int result = 0;

    public int trans(String string) {
        char[] ch = string.toCharArray();
        result = ch[0] - '0';
        switch (result) {
            case 38598:
                result = 0;
                break;
            case 19920:
                result = 1;
                break;
            case 20060:
                result = 2;
                break;
            case 19929:
                result = 3;
                break;
            case 22187:
                result = 4;
                break;
            case 20068:
                result = 5;
                break;
            case 20797:
                result = 6;
                break;
            case 19923:
                result = 7;
                break;
            case 20795:
                result = 8;
                break;
            case 20013:
                result = 9;
                break;
            case 21265:
                result = 10;
                break;
        }
        return result;
    }
}