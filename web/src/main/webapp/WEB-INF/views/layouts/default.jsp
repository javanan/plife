<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html class="signin no-js" lang="${lang}">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
    <meta name="description" content="${AppName}">
    <title><sitemesh:title/> - ${AppName}</title>
    <link rel="stylesheet" href="${ctx}/assets/plugins/stepy/jquery.stepy.css">
    <link rel="stylesheet" href="${ctx}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/assets/css/font-awesome.css">
    <link rel="stylesheet" href="${ctx}/assets/css/themify-icons.css">
    <link rel="stylesheet" href="${ctx}/assets/css/animate.min.css">
    <link rel="stylesheet" href="${ctx}/assets/css/skins/palette.css">
    <link rel="stylesheet" href="${ctx}/assets/css/fonts/font.css">
    <link rel="stylesheet" href="${ctx}/assets/css/main.css">
    <link rel="stylesheet" href="${ctx}/assets/css/panel.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/jstree/themes/default/style.min.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/treetable/jquery.treetable.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/chosen/chosen.min.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/datepicker/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/emoji/emoji.css">
    <link rel="stylesheet" href="${ctx}/assets/plugins/x-editable/bootstrap-editable.css">
    <!--[if lt IE 9]>
    <script src="${ctx}/assets/js/html5shiv.js"></script>
    <script src="${ctx}/assets/js/respond.min.js"></script>
    <script src="${ctx}/assets/js/json2.js"></script>
    <![endif]-->

    <% if(shiro.getPrincipalProperty('loginTheme')!=null){ %>
    <link rel="stylesheet" href="${ctx}/assets/css/skins/${shiro.getPrincipalProperty('loginTheme')}" id="skin">
    <% }else{ %>
    <link rel="stylesheet" href="${ctx}/assets/css/skins/palette.css" id="skin">
    <% } %>

    <script src="${ctx}/assets/plugins/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        var base = '${ctx}';
    </script>
    <sitemesh:head/>
</head>
<body>
<div class="gallery-loader" style="background-color:transparent;">
    <div class="loader"></div>
</div>

<div class="playground hidden-xs">
    <div class="options">
        <div class="pg-close ti-close"></div>
        <div class="options-container color-options">
            <h6>${msg['index.themes']}</h6>
            <a onclick="sublime.changeTheme('palette.css')" href="${ctx}/assets/css/skins/palette.css"
               class="css_orange cs_color cs_1 <% if(shiro.getPrincipalProperty('loginTheme')==null || 'palette.css' == shiro.getPrincipalProperty('loginTheme')){ %>active<% } %>">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </a>
            <a onclick="sublime.changeTheme('palette.2.css')" href="${ctx}/assets/css/skins/palette.2.css"
               class="css_orange cs_color cs_2 <% if('palette.2.css' == shiro.getPrincipalProperty('loginTheme')){ %>active<% } %>">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </a>
            <a onclick="sublime.changeTheme('palette.3.css')" href="${ctx}/assets/css/skins/palette.3.css"
               class="css_orange cs_color cs_3 <% if('palette.3.css' == shiro.getPrincipalProperty('loginTheme')){ %>active<% } %>">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </a>

        </div>
        <div class="options-container">
            <h6>${msg['index.layout']}</h6>
            <a class="pg-val toggle-sidebar toggle-active <% if(shiro.getPrincipalProperty('loginSidebar')){ %>active<% } %>" href="javascript:;">
                <img src="${ctx}/assets/img/panel/small.png" alt="">
            </a>
            <a class="pg-val toggle-scroll toggle-active <% if(shiro.getPrincipalProperty('loginScroll')){ %>active<% } %>" href="javascript:;">
                <img src="${ctx}/assets/img/panel/scroll.png" alt="">
            </a>
            <a class="pg-val toggle-boxed toggle-active <% if(shiro.getPrincipalProperty('loginBoxed')){ %>active<% } %>" href="javascript:;">
                <img src="${ctx}/assets/img/panel/boxed.png" alt="">
            </a>
        </div>
        <small class="pg-footer"><i class="ti-info-alt mr5"></i>${msg['index.panel']}</small>
    </div>
</div>
<div class="app <% if(shiro.getPrincipalProperty('loginSidebar')){ %> small-menu <% } %> <% if(shiro.getPrincipalProperty('loginScroll')){ %> fixed-scroll <% } %> <% if(shiro.getPrincipalProperty('loginBoxed')){ %> boxed <% } %>">
    <header class="header header-fixed navbar">
        <div class="brand">

            <a href="javascript:;" class="ti-menu off-left visible-xs" data-toggle="offscreen" data-move="ltr"></a>


            <a href="${ctx}/platform/home"  data-pjax class="navbar-brand">
                <img src="${ctx}/assets/img/logo.png" alt="" class="o_img <% if(!shiro.getPrincipalProperty('loginSidebar')){ %>o_hide<% } %>">
                <span class="heading-font o_img <% if(shiro.getPrincipalProperty('loginSidebar')){ %>o_hide<% } %>">
		            <img src="${ctx}/assets/img/logoa.png">
                </span>
            </a>

        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class="hidden-xs">

                <a href="javascript:;" class="toggle-sidebar">
                    <i class="ti-menu"></i>
                </a>

            </li>

        </ul>
        <ul id="topnav" class="nav navbar-nav hidden-xs">


            <%
            var secondMenus=shiro.getPrincipalProperty('secondMenus');
            for(firstMenu in shiro.getPrincipalProperty('firstMenus')){

            %>
            <li class="dropdown">

                    <% if(!isEmpty(secondMenus.get(firstMenu.path))){%>
                <a href="javascript:;" data-toggle="dropdown">
                    <% if(has(firstMenu.icon)){ %>
                    <i class="${firstMenu.icon}"></i>
                    <% } %>
                    <span>
                        <%if(lang=="zh_CN"){%>${firstMenu.name}<%}else{%>${firstMenu.aliasName}<%}%></span>
                    <b class="caret"></b
                            >
                </a>
                <%}else{%>
                    <a href="<% if(!isEmpty(firstMenu.href)){ %><%if(string.startWith(firstMenu.href,'/')){%>${base}${firstMenu.href!}<%}else{%>${firstMenu.href!}<%}%> <% }else{ %>javascript:;<% } %>" <%if(string.startWith(firstMenu.target,'_')){%>target="${firstMenu.target!}"<%}else{%>${firstMenu.target!}<%}%>>
                   <span>
                        <%if(lang=="zh_CN"){%>${firstMenu.name}<%}else{%>${firstMenu.aliasName}<%}%></span></a>
                    <%}%>
                <% if(!isEmpty(secondMenus.get(firstMenu.path))){%>
                <ul class="dropdown-menu topnav">
                    <% for(secondMenu in secondMenus.get(firstMenu.path)){ %>
                    <li class="dropdown">
                        <a href="<% if(!isEmpty(secondMenu.href)){ %><%if(string.startWith(secondMenu.href,'/')){%>${base}${secondMenu.href!}<%}else{%>${secondMenu.href!}<%}%> <% }else{ %>javascript:;<% } %>" <%if(string.startWith(secondMenu.target,'_')){%>target="${secondMenu.target!}"<%}else{%>${secondMenu.target!}<%}%>>
                            <% if(!isEmpty(secondMenus.get(secondMenu.path))){ %><i class="toggle-accordion"></i><%}%>
                            <span><%if(lang=="zh_CN"){%>${secondMenu.name}<%}else{%>${secondMenu.aliasName}<%}%></span>
                        </a>
                        <% if(!isEmpty(secondMenus.get(secondMenu.path))){ %>
                        <ul class="sub-menu">
                            <% for(thMenu in secondMenus.get(secondMenu.path)){ %>
                            <li class="clearfix" >
                                <a <% if(!isEmpty(thMenu.href)){ %>href="<%if(string.startWith(thMenu.href,'/')){%>${base}${thMenu.href!}<%}else{%>${thMenu.href!}<%}%>" <% }else{ %>href="javascript:;"<% } %> <%if(string.startWith(thMenu.target,'_')){%>target="${thMenu.target!}"<%}else{%>${thMenu.target!}<%}%>>
                                <span><%if(lang=="zh_CN"){%>${thMenu.name}<%}else{%>${thMenu.aliasName}<%}%></span>
                                </a>
                            </li><% }%>
                        </ul><%}%>
                    </li><% } %>
                </ul><% } %>
            </li><% }%>
            <li>
                <a href="https://github.com/javanan" target="_blank">GitHub</a>
            </li>
            <li>
                <a href="http://blog.csdn.net/chenjianandiyi" target="_blank">Blog</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <!--通知位置-->
            <li class="language-dropdown dropdown hidden-xs">
                <a href="javascript:;" data-toggle="dropdown" id="language">
                    <%if(lang==null||lang=="zh_CN"){%>
                    <img src="${ctx}/assets/img/flags/cn.png" class="flag">
                    <%}else{%>
                    <img src="${ctx}/assets/img/flags/us.png" class="flag">
                    <%}%>
                    <ul class="dropdown-menu dropdown-menu-right animated fadeInUp">
                        <li>
                            <a href="?lang=en_US">
                                <img src="${ctx}/assets/img/flags/us.png" class="flag">
                                <span class="language">English</span>
                            </a>
                        </li>
                        <li>
                            <a href="?lang=zh_CN">
                                <img src="${ctx}/assets/img/flags/cn.png" class="flag">
                                <span class="language">中文</span>
                            </a>
                        </li>
                    </ul>
            </li>
            <li class="off-right">
                <a href="javascript:;" data-toggle="dropdown">
                    <span class="hidden-xs ml10">${shiro.getPrincipalProperty('nickname')}</span>
                    <i class="ti-angle-down ti-caret hidden-xs"></i>
                </a>
                <ul class="dropdown-menu animated fadeInLeft">
                    <li>
                        <a href="${ctx}/platform/sys/user/custom" data-toggle="modal"
                           data-target="#homeDetail">${msg['index.custommenu']}</a>
                    </li>
                    <li class="dropdown hidden-xs">
                        <a href="javascript:;" class="pg-toggle">
                            ${msg['index.user.layout']}
                        </a>
                    </li>
                    <li class="dropdown hidden-xs">
                        <a href="${ctx}/platform/sys/user/mode" data-toggle="modal"
                           data-target="#homeDetail">
                            ${msg['index.user.mode']}
                        </a>
                    </li>
                    <li>
                        <a href="${ctx}/platform/sys/user/pass" data-toggle="modal"
                           data-target="#homeDetail">${msg['index.user.password']}</a>
                    </li>
                </ul>
            </li>
            <li class="off-right">
                <a href="${ctx}/platform/login/logout">
                    <i class="ti-power-off"></i>
                </a>
            </li>
        </ul>
    </header>
    <section class="layout">

        <aside class="sidebar offscreen-left">

            <nav class="main-navigation" data-height="auto" data-size="6px" data-distance="0" data-rail-visible="true"
                 data-wheel-step="10">
                <!--<p class="nav-title">MENU</p>-->
                <ul class="nav">
                    <li class="open">
                        <a href="javascript:;">
                            <%if(!isEmpty(shiro.getPrincipalProperty('customMenus'))){%>
                            <i class="toggle-accordion"></i>
                            <%}%>
                            <i class="ti-heart"></i>
                            <span>${msg['index.custommenu']}</span>
                        </a>
                        <%if(!isEmpty(shiro.getPrincipalProperty('customMenus'))){%>
                        <ul class="sub-menu">
                            <%for(o in shiro.getPrincipalProperty('customMenus')){%>

                            <li>
                                <a <%if(!isEmpty(o.href)){%>href="${base}${o.href}" <%if('data-pjax'==o.target){%>data-pjax<%}}else{ %>href="javascript:;"<%}%>>
                                <span><%if(lang=="zh_CN"){%>${o.name}<%}else{%>${o.aliasName}<%}%></span>
                                </a>
                            </li>

                            <%}%>
                        </ul>
                        <%}%>
                    </li>

                </ul>
                <ul id="leftnav" class="nav">
                </ul>
            </nav>
        </aside>
        <section class="main-content" id="container">
         <!--  ${layoutContent}-->
            <sitemesh:body/>
        </section>
    </section>


</div>
<div id="homeDetail" class="modal fade bs-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        </div>
    </div>
</div>
<!--script-->
<script src="${ctx}/assets/plugins/modernizr.js"></script>
<script src="${ctx}/assets/js/jquery.pjax.js"></script>
<script src="${ctx}/assets/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/assets/plugins/jquery.form.js"></script>
<script src="${ctx}/assets/plugins/parsley.min.js"></script>
<script src="${ctx}/assets/plugins/parsley.zh_cn.js"></script>
<script src="${ctx}/assets/plugins/jquery.sortable.js"></script>
<script src="${ctx}/assets/plugins/jquery.nestable.js"></script>
<script src="${ctx}/assets/plugins/icheck/icheck.js"></script>
<script src="${ctx}/assets/plugins/jquery.slimscroll.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.easing.min.js"></script>
<script src="${ctx}/assets/plugins/appear/jquery.appear.js"></script>
<script src="${ctx}/assets/plugins/jquery.placeholder.js"></script>
<script src="${ctx}/assets/plugins/fastclick.js"></script>
<script src="${ctx}/assets/plugins/count-to/jquery.countTo.js"></script>
<script src="${ctx}/assets/js/toast.js"></script>
<script src="${ctx}/assets/plugins/chosen/chosen.jquery.min.js"></script>
<script src="${ctx}/assets/plugins/treetable/jquery.treetable.js"></script>
<script src="${ctx}/assets/plugins/datatables/jquery.dataTables.js"></script>
<script src="${ctx}/assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="${ctx}/assets/plugins/jstree/jstree.min.js"></script>
<script src="${ctx}/assets/plugins/switchery/switchery.js"></script>
<script src="${ctx}/assets/plugins/stepy/jquery.stepy.js"></script>
<script src="${ctx}/assets/plugins/stepy/jquery.validate.min.js"></script>
<script src="${ctx}/assets/plugins/icheck/icheck.js"></script>
<script src="${ctx}/assets/plugins/chosen/chosen.jquery.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.form.js"></script>
<script src="${ctx}/assets/plugins/uploadifive/jquery.uploadifive.min.js"></script>
<script src="${ctx}/assets/plugins/datepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/plugins/datepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${ctx}/assets/plugins/emoji/emoji.js"></script>
<script src="${ctx}/assets/plugins/sorttable/Sortable.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.qrcode.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.sparkline.js"></script>
<script src="${ctx}/assets/plugins/x-editable/bootstrap-editable.js"></script>
<script src="${ctx}/assets/plugins/moment.min.js"></script>
<script src="${ctx}/assets/js/form.js"></script>
<script src="${ctx}/assets/js/offscreen.js"></script>
<script src="${ctx}/assets/js/main.js"></script>
<script src="${ctx}/assets/js/page.js"></script>
<script src="${ctx}/assets/js/date.js"></script>

<script type="text/javascript">
    function bindLeft(){
        $('.main-navigation a[data-pjax]').on('click',function(){
            $('.main-navigation a[data-pjax]').each(function(){
                $(this).parent().removeClass('active');
            });
            $(this).parent().addClass('active');
        });
    }
    $(document).ready(function () {

        if($.support.pjax) {
              <%if(shiro.getPrincipalProperty('loginPjax')){%>
            $(document).pjax('a[data-pjax]', '#container', {maxCacheLength:0,push:false, replace:true,fragment: '#container', timeout: 8000});
            <%}%>
            bindLeft();
            $('#topnav a[data-pjax]').on('click',function(){
                $.get("${ctx}/platform/home/left?url="+$(this).attr("href"),function (data) {
                    $("#leftnav").html(data);
                    bindLeft();
                }, "html");
            });
            $.get("${ctx}/platform/home/path?url="+window.location.href,function (data) {
                $("#leftnav").html(data);
                bindLeft();
            }, "html");
            <%if(shiro.getPrincipalProperty('loginPjax')){%>
            $(document).on('pjax:send', function () { //pjax链接点击后显示加载动画；
                $(".gallery-loader").fadeIn();
            });
            $(document).on('pjax:complete', function () { //pjax链接加载完成后隐藏加载动画；
                setTimeout(function(){$(".gallery-loader").fadeOut()},250);
            });
            <%}%>
        }

        try {
            $(".gallery-loader").fadeOut();
        } catch (e) {
        }
        $('#homeDetail').on('hidden.bs.modal',function(){
            $(this).removeData("bs.modal");
        });
        $(".toggle-sidebar").click(function(){
            $(".o_img").toggleClass("o_hide");
        });
    });
</script>
<!--script-->
</body>
</html>