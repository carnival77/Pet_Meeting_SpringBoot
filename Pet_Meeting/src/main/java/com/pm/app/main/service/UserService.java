package com.pm.app.main.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.devpro.recommend.mapper.RecommendMapper;
import com.ktds.devpro.recommend.vo.LogVO;
import com.ktds.devpro.recommend.vo.ResultVO;
import com.ktds.devpro.recommend.vo.SearchVO;

@Service
public class RecommendService {

	@Autowired
	public RecommendMapper mapper;
	Map<String, List<ResultVO>> map = new HashedMap<String, List<ResultVO>>();

	public Map<String, List<ResultVO>> selectTV(SearchVO sv) {

		List<ResultVO> result = mapper.selectTV(sv);
		List<ResultVO> result2 = mapper.selectWeightTV(sv);

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getTvService() != "none")
				result.get(i).setTotal_service(result.get(i).getTvService());
			result.get(i).setPname(result.get(i).getTvName());
		}

		for (int i = 0; i < result2.size(); i++) {
			if (result2.get(i).getTvService() != "none")
				result2.get(i).setTotal_service(result.get(i).getTvService());
			result2.get(i).setPname(result2.get(i).getTvName());
		}

		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	public Map<String, List<ResultVO>> selectInternet(SearchVO sv) {
		List<ResultVO> result = mapper.selectInternet(sv);
		List<ResultVO> result2 = mapper.selectWeightInternet(sv);

		for (int i = 0; i < result.size(); i++) {
			result.get(i).setTotal_service(result.get(i).getItnService());
			result.get(i).setPname(result.get(i).getItnName());
		}

		for (int i = 0; i < result2.size(); i++) {
			result2.get(i).setTotal_service(result2.get(i).getItnService());
			result2.get(i).setPname(result2.get(i).getItnName());
		}

		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	public Map<String, List<ResultVO>> selectMobile(SearchVO sv) {
		List<ResultVO> result = mapper.selectMobile(sv);
		List<ResultVO> result2 = mapper.selectWeightMobile(sv);

		for (int i = 0; i < result.size(); i++) {
			result.get(i).setPname(result.get(i).getMobName());
		}
		for (int i = 0; i < result2.size(); i++) {
			result2.get(i).setPname(result2.get(i).getMobName());
		}

		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	// TV+인터넷(홈 결합)
	public Map<String, List<ResultVO>> selectHome(SearchVO sv) {
		List<ResultVO> result = mapper.selectHome(sv);
		List<ResultVO> result2 = mapper.selectWeightHome(sv);

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getCombService() == "") {
				result.get(i).setTotal_service(result.get(i).getItnService() + "\n + " + result.get(i).getTvService());
			} else {
				result.get(i).setTotal_service(result.get(i).getCombService() + "\n + " + result.get(i).getTvService());
			}
			result.get(i).setPname(result.get(i).getTvName() + "+" + result.get(i).getItnName());
			result.get(i).setPrevPrice(result.get(i).getTvPrice() + result.get(i).getItnPrice());
		}

		for (int i = 0; i < result2.size(); i++) {
			if (result2.get(i).getCombService() == "") {
				result2.get(i)
						.setTotal_service(result2.get(i).getItnService() + "\n + " + result2.get(i).getTvService());
			} else {
				result2.get(i)
						.setTotal_service(result2.get(i).getCombService() + "\n + " + result2.get(i).getTvService());
			}
			result2.get(i).setPname(result2.get(i).getTvName() + "+" + result2.get(i).getItnName());
			result2.get(i).setPrevPrice(result2.get(i).getTvPrice() + result2.get(i).getItnPrice());
		}
		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	// TV+모바일 결합
	public Map<String, List<ResultVO>> selectTvMob(SearchVO sv) {
		List<ResultVO> result = mapper.selectTvMob(sv);
		List<ResultVO> result2 = mapper.selectWeightTvMob(sv);

		for (int i = 0; i < result.size(); i++) {
			result.get(i).setPname(result.get(i).getTvName() + "+" + result.get(i).getMobName());
			result.get(i).setPrevPrice(result.get(i).getTvPrice() + result.get(i).getMobPrice());
			if (result.get(i).getTvService() != "none")
				result.get(i).setTotal_service(result.get(i).getTvService());
		}

		for (int i = 0; i < result2.size(); i++) {
			result2.get(i).setPname(result2.get(i).getTvName() + "+" + result2.get(i).getMobName());
			result2.get(i).setPrevPrice(result2.get(i).getTvPrice() + result2.get(i).getMobPrice());
			if (result2.get(i).getTvService() != "none")
				result2.get(i).setTotal_service(result2.get(i).getTvService());
		}
		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	// TV+인터넷+모바일 결합
	public Map<String, List<ResultVO>> selectTotal(SearchVO sv) {
		List<ResultVO> result = mapper.selectTotal(sv);
		List<ResultVO> result2 = mapper.selectWeightTotal(sv);

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getCombService().equals("")) {
				result.get(i).setTotal_service(result.get(i).getItnService() + "\n + " + result.get(i).getTvService());
			} else {
				result.get(i).setTotal_service(result.get(i).getCombService() + "\n + " + result.get(i).getTvService());
			}
			result.get(i).setPname(
					result.get(i).getTvName() + "+" + result.get(i).getItnName() + "+" + result.get(i).getMobName());
			result.get(i).setPrevPrice(
					result.get(i).getTvPrice() + result.get(i).getItnPrice() + result.get(i).getMobPrice());
		}

		for (int i = 0; i < result2.size(); i++) {
			if (result2.get(i).getCombService().equals("")) {
				result2.get(i)
						.setTotal_service(result2.get(i).getItnService() + "\n + " + result2.get(i).getTvService());
			} else {
				result2.get(i)
						.setTotal_service(result2.get(i).getCombService() + "\n + " + result2.get(i).getTvService());
			}
			result2.get(i).setPname(
					result2.get(i).getTvName() + "+" + result2.get(i).getItnName() + "+" + result2.get(i).getMobName());
			result2.get(i).setPrevPrice(
					result2.get(i).getTvPrice() + result2.get(i).getItnPrice() + result2.get(i).getMobPrice());
		}
		map.put("priceResult", result);
		map.put("weightResult", result2);

		return map;
	}

	// 단일 상품 선택 후 관련 결합 상품 추천
	public List<ResultVO> selectTvComb(LogVO cv) {
		return mapper.selectTvComb(cv);
	}

	public List<ResultVO> selectItnComb(LogVO cv) {
		return mapper.selectItnComb(cv);
	}

	public List<ResultVO> selectMobComb(LogVO cv) {
		return mapper.selectMobComb(cv);
	}

	// 로그 추가
	public int logInsert(LogVO log) {
		return mapper.logInsert(log);
	}

	// 방문자수 증가
	public int visitCnt() {
		return mapper.visitCnt();
	}

}