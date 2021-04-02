package com.ktds.devpro.adminLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.devpro.adminLog.mapper.AdminLogMapper;
import com.ktds.devpro.adminLog.vo.ResultLogVO;
import com.ktds.devpro.adminLog.vo.ResultLogVO2;
import com.ktds.devpro.adminLog.vo.SearchLogVO;

@Service
public class AdminLogService {

	@Autowired
	public AdminLogMapper mapper;

	public List<ResultLogVO> selectAllLog() {
		return mapper.selectAllLog();
	}

	public List<ResultLogVO> selectTVLog(SearchLogVO slv) {
		return mapper.selectTVLog(slv);
	}

	public List<ResultLogVO> selectItnLog(SearchLogVO slv) {
		return mapper.selectItnLog(slv);
	}

	public List<ResultLogVO> selectMobLog(SearchLogVO slv) {
		return mapper.selectMobLog(slv);
	}

	public List<ResultLogVO> selectItnMobLog(SearchLogVO slv) {
		return mapper.selectItnMobLog(slv);
	}

	public List<ResultLogVO> selectHomeLog(SearchLogVO slv) {
		return mapper.selectHomeLog(slv);
	}

	public List<ResultLogVO> selectTvMobLog(SearchLogVO slv) {
		return mapper.selectTvMobLog(slv);
	}

	public List<ResultLogVO> selectTotalLog(SearchLogVO slv) {
		return mapper.selectTotalLog(slv);
	}
	
	public ResultLogVO2 selectWeekMonthData() {
		ResultLogVO2 logvo2=new ResultLogVO2();
		logvo2.setWeekTotalPrice(100);
		
		String month[]=new String[6];
		int thrMonthTvCnt[]= new int[6];
		int thrMonthItnCnt[]= new int[6];
		int thrMonthMobCnt[]= new int[6];
		int thrMonthCombCnt[]= new int[6];

		for(int i=0; i<=5; i++) {
			String map0=(String)mapper.thrMonthCnt(i);
			Integer map1=(Integer)mapper.thrMonthTvCnt(i);
			Integer map2=(Integer)mapper.thrMonthItnCnt(i);
			Integer map3=(Integer)mapper.thrMonthMobCnt(i);
			Integer map4=(Integer)mapper.thrMonthCombCnt(i);
			
			month[i]=map0;

			if(map1==null) {
				thrMonthTvCnt[i]=0;
			}
			else {
				thrMonthTvCnt[i]=map1;
			}
			if(map2==null) 	{
				thrMonthItnCnt[i]=0;
			}
			else {
				thrMonthItnCnt[i]=map2;
			}
			if(map3==null) {
				thrMonthMobCnt[i]=0;
			}
			else {
				thrMonthMobCnt[i]=map3;
			}
			if(map4==null) {
				thrMonthCombCnt[i]=0;
			}
			else {
				thrMonthCombCnt[i]=map4;
			}
		}

		ResultLogVO2 week=mapper.selectWeekData();
		ResultLogVO2 lastweek=mapper.selectWeekPrevData();

		logvo2.setWeekTotalPrice(week.getWeekTotalPrice());
		logvo2.setWeekTotalOrder(week.getWeekTotalOrder());
		logvo2.setWeekPrevOrderPer(lastweek.getWeekPrevOrderPer()==0 ? 987654321 : (week.getWeekTotalOrder() - lastweek.getWeekPrevOrderPer()) / lastweek.getWeekPrevOrderPer());
		logvo2.setWeekPrevPricePer(lastweek.getWeekPrevPricePer()==0 ? 987654321 : (week.getWeekTotalPrice() - lastweek.getWeekPrevPricePer()) / lastweek.getWeekPrevPricePer());
		logvo2.setMonth(month);
		logvo2.setThrMonthTvCnt(thrMonthTvCnt);
		logvo2.setThrMonthItnCnt(thrMonthItnCnt);
		logvo2.setThrMonthMobCnt(thrMonthMobCnt);
		logvo2.setThrMonthCombCnt(thrMonthCombCnt);
		
		return logvo2;
	}
	
	// 방문자수 출력
	public int visitCntPrint() {
		return mapper.visitCntPrint();
	}

}