package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

    private static java.util.List<String> _jspx_dependants;

    private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
    private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
    private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sec_authorize_access;
    private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value_nobody;
    private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

    private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

    public java.util.List<String> getDependants() {
        return _jspx_dependants;
    }

    public void _jspInit() {
        _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _jspx_tagPool_sec_authorize_access = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _jspx_tagPool_c_url_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    }

    public void _jspDestroy() {
        _jspx_tagPool_c_out_value_nobody.release();
        _jspx_tagPool_c_forEach_var_items.release();
        _jspx_tagPool_sec_authorize_access.release();
        _jspx_tagPool_c_url_var_value_nobody.release();
        _jspx_tagPool_c_if_test.release();
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse response)
            throws java.io.IOException, ServletException {

        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        JspWriter _jspx_out = null;
        PageContext _jspx_page_context = null;

        try {
            response.setContentType("text/html;charset=UTF-8");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;
            _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

            out.write("\r\n");
            out.write("\r\n");
            out.write("\r\n");
            out.write("\r\n");
            out.write("<html>\r\n");
            out.write("<head>\r\n");
            out.write("    <title></title>\r\n");
            out.write("</head>\r\n");
            out.write("<body>\r\n");
            out.write("\r\n");
            if (_jspx_meth_c_url_0(_jspx_page_context))
                return;
            out.write("\r\n");
            out.write("\r\n");
            if (_jspx_meth_c_if_0(_jspx_page_context))
                return;
            out.write("\r\n");
            out.write("\r\n");
            if (_jspx_meth_sec_authorize_0(_jspx_page_context))
                return;
            out.write("\r\n");
            out.write("\r\n");
            out.write("</body>\r\n");
            out.write("</html>\r\n");
        } catch (Throwable t) {
            if (!(t instanceof SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    out.clearBuffer();
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
                else throw new ServletException(t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }

    private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
            throws Throwable {
        PageContext pageContext = _jspx_page_context;
        JspWriter out = _jspx_page_context.getOut();
        //  c:url
        org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
        _jspx_th_c_url_0.setPageContext(_jspx_page_context);
        _jspx_th_c_url_0.setParent(null);
        _jspx_th_c_url_0.setVar("addUrl");
        _jspx_th_c_url_0.setValue("/dict/1/0");
        int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
        if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
            return true;
        }
        _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
        return false;
    }

    private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
            throws Throwable {
        PageContext pageContext = _jspx_page_context;
        JspWriter out = _jspx_page_context.getOut();
        //  c:if
        org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
        _jspx_th_c_if_0.setPageContext(_jspx_page_context);
        _jspx_th_c_if_0.setParent(null);
        _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty elements}", java.lang.Boolean.class, (PageContext) _jspx_page_context, null)).booleanValue());
        int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
        if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
                out.write("\r\n");
                out.write("    <ol>\r\n");
                out.write("        ");
                if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
                    return true;
                out.write("\r\n");
                out.write("    </ol>\r\n");
                int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
            } while (true);
        }
        if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
            return true;
        }
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return false;
    }

    private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
            throws Throwable {
        PageContext pageContext = _jspx_page_context;
        JspWriter out = _jspx_page_context.getOut();
        //  c:forEach
        org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
        _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
        _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
        _jspx_th_c_forEach_0.setVar("elem");
        _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${elements}", java.lang.Object.class, (PageContext) _jspx_page_context, null));
        int[] _jspx_push_body_count_c_forEach_0 = new int[]{0};
        try {
            int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
            if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                    out.write("\r\n");
                    out.write("            <li>\r\n");
                    out.write("                ");
                    if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
                        return true;
                    out.write("\r\n");
                    out.write("            </li>\r\n");
                    out.write("        ");
                    int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                } while (true);
            }
            if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
        } catch (Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
                out = _jspx_page_context.popBody();
            _jspx_th_c_forEach_0.doCatch(_jspx_exception);
        } finally {
            _jspx_th_c_forEach_0.doFinally();
            _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
        }
        return false;
    }

    private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
            throws Throwable {
        PageContext pageContext = _jspx_page_context;
        JspWriter out = _jspx_page_context.getOut();
        //  c:out
        org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
        _jspx_th_c_out_0.setPageContext(_jspx_page_context);
        _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
        _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${elem.name}", java.lang.Object.class, (PageContext) _jspx_page_context, null));
        int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
        if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
            return true;
        }
        _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
        return false;
    }

    private boolean _jspx_meth_sec_authorize_0(PageContext _jspx_page_context)
            throws Throwable {
        PageContext pageContext = _jspx_page_context;
        JspWriter out = _jspx_page_context.getOut();
        //  sec:authorize
        org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_authorize_0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _jspx_tagPool_sec_authorize_access.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
        _jspx_th_sec_authorize_0.setPageContext(_jspx_page_context);
        _jspx_th_sec_authorize_0.setParent(null);
        _jspx_th_sec_authorize_0.setAccess("hasAuthority('ADMIN') or hasPermission(#dict, 'CREATE') or hasPermission(#dict, 'ADMINISTRATION')");
        int _jspx_eval_sec_authorize_0 = _jspx_th_sec_authorize_0.doStartTag();
        if (_jspx_eval_sec_authorize_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("    <a href=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${addUrl}", java.lang.String.class, (PageContext) _jspx_page_context, null));
            out.write("\">добавить</a>\r\n");
        }
        if (_jspx_th_sec_authorize_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_sec_authorize_access.reuse(_jspx_th_sec_authorize_0);
            return true;
        }
        _jspx_tagPool_sec_authorize_access.reuse(_jspx_th_sec_authorize_0);
        return false;
    }
}
