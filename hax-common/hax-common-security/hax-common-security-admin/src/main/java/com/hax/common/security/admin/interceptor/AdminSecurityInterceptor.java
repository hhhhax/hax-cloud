package com.hax.common.security.admin.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminSecurityInterceptor extends HandlerInterceptorAdapter {

//    @Reference(validation = "true", version = "${dubbo.consumer.OAuth2Rpc.version}")
//    private OAuth2Rpc oauth2Rpc;
//    @Reference(validation = "true", version = "${dubbo.consumer.PermissionRpc.version}")
//    private PermissionRpc permissionRpc;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        // 获得访问令牌
//        Integer adminId = this.obtainAdminId(request);
//        // 校验认证
//        this.checkAuthentication((HandlerMethod) handler, adminId);
//        // 校验权限
//        this.checkPermission((HandlerMethod) handler, adminId);
//        return true;
//    }
//
//    private Integer obtainAdminId(HttpServletRequest request) {
//        String accessToken = HttpUtil.obtainAuthorization(request);
//        Integer adminId = null;
//        if (accessToken != null) {
//            CommonResult<OAuth2AccessTokenVO> checkAccessTokenResult = oauth2Rpc.checkAccessToken(accessToken);
//            checkAccessTokenResult.checkError();
//            // 校验用户类型正确
//            if (!UserTypeEnum.ADMIN.getValue().equals(checkAccessTokenResult.getData().getUserType())) {
//                throw ServiceExceptionUtil.exception(OAUTH_USER_TYPE_ERROR);
//            }
//            // 获得用户编号
//            adminId = checkAccessTokenResult.getData().getUserId();
//            // 设置到 Request 中
//            CommonWebUtil.setUserId(request, adminId);
//            CommonWebUtil.setUserType(request, UserTypeEnum.ADMIN.getValue());
//            // 设置到
//            AdminSecurityContext adminSecurityContext = new AdminSecurityContext().setAdminId(adminId);
//            AdminSecurityContextHolder.setContext(adminSecurityContext);
//        }
//        return adminId;
//    }
//
//    private void checkAuthentication(HandlerMethod handlerMethod, Integer adminId) {
//        boolean requiresAuthenticate = !handlerMethod.hasMethodAnnotation(RequiresNone.class); // 对于 ADMIN 来说，默认需登录
//        if (requiresAuthenticate && adminId == null) {
//            throw ServiceExceptionUtil.exception(SystemErrorCodeEnum.OAUTH2_NOT_AUTHENTICATION);
//        }
//    }
//
//    private void checkPermission(HandlerMethod handlerMethod, Integer adminId) {
//        RequiresPermissions requiresPermissions = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
//        if (requiresPermissions == null) {
//            return;
//        }
//        String[] permissions = requiresPermissions.value();
//        if (CollectionUtils.isEmpty(permissions)) {
//            return;
//        }
//        // 权限验证
//        permissionRpc.checkPermission(new PermissionCheckDTO().setAdminId(adminId).setPermissions(Arrays.asList(permissions)))
//                .checkError();
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        // 清空 SecurityContext
//        AdminSecurityContextHolder.clear();
//    }

}
