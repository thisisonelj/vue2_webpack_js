package com.example.demo.subdemo4.shoputils;

public enum ResultCode {
    SUCCESS(200,"SUCCESS")
    ,NORMAL_ERROR(500,"通用错误")
    // 参数错误
    ,PARAMS_IS_NULL(100001,"参数为空")
    ,PARAMS_NOT_COMPLETE(100002,"参数不全")
    ,PARAMS_TYPE_ERROR(100003,"参数类型错误")
    ,PARAMS_IS_INVALID(100004,"参数无效")
    // 用户错误
    ,USER_NOT_EXIST(200001,"用户不存在")
    ,USER_NOT_LOGGED_IN(200002,"用户未登陆")
    ,USER_ACCOUNT_ERROR(200003,"用户名或密码错误")
    ,USER_ACCOUNT_FORBIDDEN(200004,"用户账户已被禁用")
    ,USER_HAS_EXIST(200005,"用户已存在")
    ,USER_UNIT_NOT_EXIST(200006,"用户登录机构不存在")
    ,USER_PWD_NOT_EXIST(200007,"用户密码为空")
    ,USER_GROUP_DELETE_SUCCESS(200,"用户分组删除成功")
    ,USER_DELETE_SUCCESS(200,"用户删除成功")
    ,USER_DELETE_FAIL(200007,"用户删除成功")
    ,USER_KOAL_FAIL_MANY(200008,"通过认证标识找到多个用户，请联系管理员")
    ,USER_KOAL_FAIL_NO_ONE(200009,"通过认证标识未找到用户，请联系管理员")
    // 业务错误
    ,BUSINESS_ERROR(300001,"系统业务出现问题")
    // 系统错误
    ,SYSTEM_INNER_ERROR(400001,"系统内部错误")
    // 数据错误
    ,DATA_NOT_FOUND(500001,"数据未找到")
    ,DATA_IS_WRONG(500002,"数据有误")
    ,DATA_ALREADY_EXISTED(500003,"数据已存在")
    ,DATA_BASEDATA_MENU_NOT_FOUND(500004,"未找到基础数据执行菜单，请联系管理员")
    // 接口错误
    ,INTERFACE_INNER_INVOKE_ERROR(600001,"系统内部接口调用异常")
    ,INTERFACE_OUTER_INVOKE_ERROR(600002,"系统外部接口调用异常")
    ,INTERFACE_FORBIDDEN(600003,"接口禁止访问")
    ,INTERFACE_ADDRESS_INVALID(600004,"接口地址无效")
    ,INTERFACE_REQUEST_TIMEOUT(600005,"接口请求超时")
    ,INTERFACE_EXCEED_LOAD(600006,"接口负载过高")
    // 权限错误
    ,PERMISSION_NO_ACCESS(700001,"没有访问权限")
    ,AUTH_ROLE_001(700010,"角色分组名称不能为空！")
    ,AUTH_ROLE_002(700011,"角色分组名称重复！")
    ,AUTH_ROLE_003(700012,"角色标识不能为空！")
    ,AUTH_ROLE_004(700013,"角色标识重复！")
    ,AUTH_ROLE_005(700014,"没有当前操作权限！")
    ,AUTH_ROLE_006(700015,"密码验证失败！")
    ,AUTH_ROLE_007(700016,"导入模板有误！")
    ,AUTH_ROLE_008(700017,"删除用户时，请不要选择自己！")
    ,AUTH_ROLE_0018(700018,"设置角色失败！");

    ResultCode(Integer status,String msg){
        this.status = status ;
        this.msg = msg ;
    }

    private Integer status ;
    private String msg ;
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
