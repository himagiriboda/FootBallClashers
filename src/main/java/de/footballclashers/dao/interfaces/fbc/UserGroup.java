package de.footballclashers.dao.interfaces.fbc;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserGroup {
	/* public void insert(@Param("leagueId") int leagueId, @Param("groupName") String groupName,
			@Param("createdBy") int createdBy);*/
	public void insert(Map<String,Object> dataMap);
}
