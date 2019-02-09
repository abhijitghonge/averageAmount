package com.ag.config;


import static com.ag.config.Constants.COMMA;
import static com.ag.config.Constants.TAB;

public enum FileConfig {
    CREDIT_DATA_FILE("data/FILE.DAT", TAB),
    EXCHANGE_RATES_FILE("config/exchangeRates.csv", COMMA);

    private final String filePath;
    private final String delimiter;


    FileConfig(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getDelimiter() {
        return this.delimiter;
    }


}
