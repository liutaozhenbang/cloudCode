//package com.liutao.providerone;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Service;
//
///**
// * 该节点是否可以向外提供服务，如果可以返回true，如果不可以返回false
// * 返回false后，仍然会向eureka发送心跳，只不过status=DOWN
// * eureka不会删除该节点，只是在向外提供节点列表的时候只是提供status=UP状态的节点
// *
// * Created by liutao20 on 2020/7/17
// */
//@Service
//public class HealthStatusService implements HealthIndicator {
//
//    private boolean status = true;
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    @Override
//    public Health health() {
//        if (status) {
//            return new Health.Builder().up().build();
//        }
//        return new Health.Builder().down().build();
//    }
//}
