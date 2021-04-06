package com.pm.app.application.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ApplicationController {

//   @Autowired
//   public RecommendService service;
//
//   // 방문자수 cnt
//   @GetMapping("/visitcnt")
//   public void visitcnt() {
//	   int n=service.visitCnt();
//   }
//   
//   // 사용자 상품 가입 시 로그데이터 삽입
//   @PostMapping("/selection")
//   public void selection(@RequestBody Map<String, Object> map) {
//      LogVO log=new LogVO((String)map.get("pname"), 
//            (int)map.get("age"), 
//            (int)map.get("family"), 
//            (String)map.get("tvName"), 
//            (String)map.get("itnName"), 
//            (String)map.get("mobName"),
//            (int)map.get("prevPrice"),
//            (int)map.get("totalPrice"), 
//            (String)map.get("total_service"), 
//            (boolean)map.get("combine"),
//            (String)map.get("Date")
//            );   
//      int n = service.logInsert(log);
//   }
//   
//   // 추천 상품 결과(Restful)
//   @PostMapping("/submit")
//   public Map<String, List<ResultVO>> submit(@RequestBody SearchVO userinfo) {
//	   
//      // TV : tv_due = 0 이면 선택 x / Internet : itn_speed = 0 이면 선택 x / mobile :
//      // mob_data=-1 이면 선택x
//      Map<String, List<ResultVO>> result=new HashedMap<String, List<ResultVO>>();
//      //List<ResultVO> selectHome = null;
//
//      // 1. TV+인터넷+모바일 선택시
//      if ((userinfo.getTv_due() != 0) && (userinfo.getItn_speed() != 0) && (userinfo.getMob_data() != -1)) {
//         String tv_ser[] = userinfo.getTv_ser();
//         String tv_service = "";
//
//         if (userinfo.getTv_ser() == null) // TV 부가서비스 해당없음 선택 시 none
//            tv_service = "none";
//         else {
//            for (int i = 0; i < tv_ser.length; i++) {
//               tv_service += tv_ser[i];
//               if (i == tv_ser.length - 1)
//                  break;
//               tv_service += "|";
//            }
//         }
//
//         userinfo.setTv_service(tv_service);
//         result = service.selectTotal(userinfo);
//      }
//
//      // 2. TV+인터넷(홈결합) 선택시
//      else if ((userinfo.getTv_due() != 0) && (userinfo.getItn_speed() != 0)) {
//         String tv_ser[] = userinfo.getTv_ser();
//         String tv_service = "";
//
//         if (userinfo.getTv_ser() == null) // TV 부가서비스 해당없음 선택 시 none
//            tv_service = "none";
//         else {
//            for (int i = 0; i < tv_ser.length; i++) {
//               tv_service += tv_ser[i];
//               if (i == tv_ser.length - 1)
//                  break;
//               tv_service += "|";
//            }
//         }
//
//         userinfo.setTv_service(tv_service);
//         result = service.selectHome(userinfo);
//      }
//
//      // 3. 인터넷 + 모바일 선택시      // 단일상품 2개로 출력되므로 처리할 때 유의
//      else if ((userinfo.getItn_speed() != 0) && (userinfo.getMob_data() != -1)) {
//         result = service.selectInternet(userinfo);
//         result.get("priceResult").addAll(service.selectMobile(userinfo).get("priceResult"));
//      }
//
//      // 4. TV+모바일 선택시
//      else if ((userinfo.getTv_due() != 0) && (userinfo.getMob_data() != -1)) {
//         String tv_ser[] = userinfo.getTv_ser();
//         String tv_service = "";
//
//         if (userinfo.getTv_ser() == null) // TV 부가서비스 해당없음 선택 시 none
//            tv_service = "none";
//         else {
//            for (int i = 0; i < tv_ser.length; i++) {
//               tv_service += tv_ser[i];
//               if (i == tv_ser.length - 1)
//                  break;
//               tv_service += "|";
//            }
//         }
//
//         userinfo.setTv_service(tv_service);
//         result = service.selectTvMob(userinfo);
//      }
//
//      // 5. tv 선택시
//      else if (userinfo.getTv_due() != 0) {
//         String tv_ser[] = userinfo.getTv_ser();
//         String tv_service = "";
//
//         if (userinfo.getTv_ser() == null) // TV 부가서비스 해당없음 선택 시 none
//            tv_service = "none";
//         else {
//            for (int i = 0; i < tv_ser.length; i++) {
//               tv_service += tv_ser[i];
//               if (i == tv_ser.length - 1)
//                  break;
//               tv_service += "|";
//            }
//         }
//         userinfo.setTv_service(tv_service);
//         result = service.selectTV(userinfo);
//         
//         // 관련 결합상품 출력
//         LogVO addinfo=new LogVO();   
//           addinfo.setAge(userinfo.getAge());
//           addinfo.setFamily(userinfo.getFamily());
//           addinfo.setTv_name(result.get("priceResult").get(0).getTvName());
//
//           result.get("priceResult").addAll(service.selectTvComb(addinfo));
//      }
//
//      // 6. 인터넷 선택시
//      else if (userinfo.getItn_speed() != 0) {
//         result = service.selectInternet(userinfo);
//         
//         // 관련 결합상품 출력
//         LogVO addinfo=new LogVO();   
//           addinfo.setAge(userinfo.getAge());
//           addinfo.setFamily(userinfo.getFamily());
//           addinfo.setItn_name(result.get("priceResult").get(0).getItnName());
//
//           result.get("priceResult").addAll(service.selectItnComb(addinfo));
//      }
//
//      // 7. 모바일 선택시
//      else if (userinfo.getMob_data() != -1) {
//         result = service.selectMobile(userinfo);
//         
//         // 관련 결합상품 출력
//         LogVO addinfo=new LogVO();   
//           addinfo.setAge(userinfo.getAge());
//           addinfo.setFamily(userinfo.getFamily());
//           addinfo.setMob_name(result.get("priceResult").get(0).getMobName());
//
//           result.get("priceResult").addAll(service.selectMobComb(addinfo));
//      }
//
//      return result;
//   }
}