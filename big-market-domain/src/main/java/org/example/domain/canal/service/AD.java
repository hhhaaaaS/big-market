/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.domain.canal.service
 * @Author: 黄勇铭
 * @CreateTime: 2025-10-22  10:40
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.domain.canal.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetSocketAddress;
import java.util.List;

public class AD {
    public static void main(String[] args) {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress("117.72.147.85", 11111), "example", "", "");
        canalConnector.connect();
        canalConnector.subscribe("big_market.*");
        while (true) {
            Message message = canalConnector.get(100);
            List<CanalEntry.Entry> entries = message.getEntries();
            if (entries.size() <= 0) {
                System.out.println("当次抓取没有数据，休息一会。。。。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (CanalEntry.Entry entry : entries) {
                    //1.获取表名
                    String tableName = entry.getHeader().getTableName();
                    //2.获取类型
                    CanalEntry.EntryType entryType = entry.getEntryType();
                    //3.获取序列化后的数据
                    ByteString storeValue = entry.getStoreValue();
                    //4.判断当前entryType类型是否为ROWDATA
                    if (CanalEntry.EntryType.ROWDATA.equals(entryType)) {
                        //5.反序列化数据
                        CanalEntry.RowChange rowChange = null;
                        try {
                            rowChange = CanalEntry.RowChange.parseFrom(storeValue);
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                        //6.获取当前事件的操作类型
                        CanalEntry.EventType eventType = rowChange.getEventType();
                        //7.获取数据集
                        List<CanalEntry.RowData> rowDataList = rowChange.getRowDatasList();
                        //8.遍历rowDataList，并打印数据集
                        for (CanalEntry.RowData rowData : rowDataList) {
                            JSONObject beforeData = new JSONObject();
                            List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
                            for (CanalEntry.Column column : beforeColumnsList) {
                                beforeData.put(column.getName(), column.getValue());
                            }

                            JSONObject afterData = new JSONObject();
                            List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
                            for (CanalEntry.Column column : afterColumnsList) {
                                afterData.put(column.getName(), column.getValue());
                            }

                            //数据打印
                            System.out.println("Table:" + tableName +
                                    ",EventType:" + eventType +
                                    ",Before:" + beforeData +
                                    ",After:" + afterData);
                        }
                    } else {
                        System.out.println("当前操作类型为：" + entryType);
                    }
                }
            }
        }
    }
}