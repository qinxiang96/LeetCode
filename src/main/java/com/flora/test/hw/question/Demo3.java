package com.flora.test.hw.question;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/12/21-下午2:52
 * 运动场上有很多组照明设备，下面A集合中，描述出了不同照明设备的启动（begintime）停止（endtime）时间，照明设备的id已经处理掉了无需考虑，仔细看这些时间段可以发现，这些时间有重合（表示这段时间多组照明同时亮）、有空挡（表示这段时间一组照明都没有开）。请通过java代码实现，获得此足球场上有照明设备开启的时间段集合（求A集合在时间维度上的并集）。
 * A集合：
 * [{begintime:2020-01-01 00:04:00,endtime:2020-01-01 00:06:00},
 * {begintime:2020-01-01 00:01:05,endtime:2020-01-01 00:03:15},
 * {begintime:2020-01-01 00:09:00,endtime:2020-01-01 00:10:00},
 * {begintime:2020-01-01 00:07:35,endtime:2020-01-01 00:08:40},
 * {begintime:2020-01-01 00:12:00,endtime:2020-01-01 00:17:00},
 * {begintime:2020-01-01 00:12:05,endtime:2020-01-01 00:13:10},
 * {begintime:2020-01-01 00:19:00,endtime:2020-01-01 00:21:00},
 * {begintime:2020-01-01 00:15:20,endtime:2020-01-01 00:20:45}]
 * ﻿
 * 期望得到的输出结果：
 * [{begintime:2020-01-01 00:01:05,endtime:2020-01-01 00:03:15},
 * {begintime:2020-01-01 00:04:00,endtime:2020-01-01 00:06:00},
 * {begintime:2020-01-01 00:07:35,endtime:2020-01-01 00:08:40},
 * {begintime:2020-01-01 00:09:00,endtime:2020-01-01 00:10:00},
 * {begintime:2020-01-01 00:12:00,endtime:2020-01-01 00:21:00}]
 */
public class Demo3 {
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("beginTime:2020-01-01 00:04:00,endTime:2020-01-01 00:06:00");
        list.add("beginTime:2020-01-01 00:01:05,endTime:2020-01-01 00:03:15");
        list.add("beginTime:2020-01-01 00:09:00,endTime:2020-01-01 00:10:00");
        list.add("begintime:2020-01-01 00:07:35,endtime:2020-01-01 00:08:40");
        list.add("begintime:2020-01-01 00:12:00,endtime:2020-01-01 00:17:00");
        list.add("begintime:2020-01-01 00:12:05,endtime:2020-01-01 00:13:10");
        list.add("begintime:2020-01-01 00:19:00,endtime:2020-01-01 00:21:00");
        list.add("begintime:2020-01-01 00:15:20,endtime:2020-01-01 00:20:45");
        List<TimeCompar> timePairList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] startAndEnd = str.split(",");
            int indexStart = startAndEnd[0].indexOf("2");
            String start = startAndEnd[0].substring(indexStart);
            int indexEnd = startAndEnd[1].indexOf("2");
            String end = startAndEnd[1].substring(indexEnd);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = simpleDateFormat.parse(start);
            Date endDate = simpleDateFormat.parse(end);
            TimeCompar timeCompar = new TimeCompar(startDate.getTime(), endDate.getTime());
            timePairList.add(timeCompar);
        }
        //这样结束后timePairList中存的就是所有的起始时间对象，如果这个List为null或者无参数
        //调用list集合的sort方法，给定排序规则进行排序
        /* Comparator.comparingLong方法接受一个函数作为参数，该参数从类型T中提取一个长排序键，
         * 然后返回一个与该排序键进行比较的Comparator。指定的函数也可以序列化。
         */
        timePairList.sort(Comparator.comparingLong(TimeCompar::getStart));
        //排好序之后遍历比较，如果后一个的开始时间小于前一个的结束时间就说明有交集,将交集时间段打印
        Long tmpStart = timePairList.get(timePairList.size() - 1).getStart();
        Long tmpEnd = timePairList.get(0).getEnd();
        for (int i = 1; i < timePairList.size(); i++) {
            Long nextStart = timePairList.get(i).getStart();
            Long lastStart = timePairList.get(i - 1).getStart();
            Long lastEnd = timePairList.get(i - 1).getEnd();
            Long nextEnd = timePairList.get(i).getEnd();
            if (lastEnd > nextStart) {
                    tmpStart = Math.min(tmpStart, lastStart);
                    tmpEnd = Math.max(lastEnd, nextEnd);
                    timePairList.get(i).setEnd(tmpEnd);
                    continue;
            }else {
                System.out.println("beginTime:" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                                format(new Date(lastStart)) +
                        ",endTime:" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                                format(new Date(lastEnd)));
            }
        }
        System.out.println("beginTime:" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                        format(new Date(tmpStart)) +
                ",endTime:" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                        format(new Date(tmpEnd)));

    }
//    @Data
    public static class TimeCompar {
        private Long start;
        private Long end;

        public TimeCompar(Long start , Long end){
            if(end.compareTo(start) < 0){
                //抛异常
                throw new DateTimeException("结束时间不能小于开始时间");
            }
            this.start = start;
            this.end = end;
        }

        public Long getStart() {
            return start;
        }

        public void setStart(Long start) {
            this.start = start;
        }

        public Long getEnd() {
            return end;
        }

        public void setEnd(Long end) {
            this.end = end;
        }
    }


}
