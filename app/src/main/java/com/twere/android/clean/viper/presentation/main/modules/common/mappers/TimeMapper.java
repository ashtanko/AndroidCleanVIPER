package com.twere.android.clean.viper.presentation.main.modules.common.mappers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMapper {
  public static String transform(long timestamp) {
    return SimpleDateFormat.getDateTimeInstance().format(new Date(timestamp));
  }
}