package com.baozi.util;

import com.baozi.po.SysPermission;
import com.baozi.po.SysRole;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wenjun.zhang
 * @create 2018-04-27 11:21
 * @description
 **/
public class PermissionDataFactory {

    /**
     * 把查询出来的roles 转换成layui 的 tree数据
     * @param roles
     * @return
     */
    public static List<Map<String,Object>> toTreeData(List<SysRole> roles){
        List<Map<String,Object>> resultData = new LinkedList<Map<String,Object>>();
        for (SysRole u : roles) {
            Map<String,Object> map = new LinkedHashMap<String, Object>();
            map.put("name", u.getName());
            List<SysPermission> ps = u.getPermissions();
            map.put("tags",  new Integer[]{ps.size()});
            if(null != ps && ps.size() > 0){
                List<Map<String,Object>> list = new LinkedList<Map<String,Object>>();
                for (SysPermission up : ps) {
                    Map<String,Object> mapx = new LinkedHashMap<String, Object>();
                    mapx.put("name", up.getName());
                    mapx.put("href", up.getUrl()+".shtml");
                    list.add(mapx);
                }
                map.put("children", list);
            }
            resultData.add(map);
        }
        return resultData;
    }
}
