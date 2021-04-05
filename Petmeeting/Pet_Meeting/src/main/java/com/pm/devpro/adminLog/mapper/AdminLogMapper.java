package com.ktds.devpro.adminLog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ktds.devpro.adminLog.vo.ResultLogVO;
import com.ktds.devpro.adminLog.vo.ResultLogVO2;
import com.ktds.devpro.adminLog.vo.SearchLogVO;

@Mapper
public interface AdminLogMapper {

	public List<ResultLogVO> selectAllLog();
	public List<ResultLogVO> selectTVLog(SearchLogVO slv);
	public List<ResultLogVO> selectItnLog(SearchLogVO slv);
	public List<ResultLogVO> selectMobLog(SearchLogVO slv);
	public List<ResultLogVO> selectItnMobLog(SearchLogVO slv);
	public List<ResultLogVO> selectHomeLog(SearchLogVO slv);
	public List<ResultLogVO> selectTvMobLog(SearchLogVO slv);
	public List<ResultLogVO> selectTotalLog(SearchLogVO slv);
	
	public ResultLogVO2 selectWeekData();
	public ResultLogVO2 selectWeekPrevData();
	
	public String thrMonthCnt(int ago);
	public Integer thrMonthTvCnt(int month);
	public Integer thrMonthItnCnt(int month);
	public Integer thrMonthMobCnt(int month);
	public Integer thrMonthCombCnt(int month);
	
	public int visitCntPrint();

	
}