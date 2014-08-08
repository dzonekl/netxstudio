<%@ page import="java.util.*, java.io.*, util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<style>
            body {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                /* background-color: #e9008f; */
                margin: 0px auto;
                padding: 15px;
                font-size: 10px;
            }
            body.a {
            	font-size: 10px;
            }
            
            h1 {
                font-size: 26px;
                /* color: #FFFFFF; */
            }
            h2 {
                font-size: 22px;
                font-style: italic;
                color: #FFFFFF;
            }
            table {
                border: solid 1px #e8eff4;
                background-color: #FFFFFF;
                font-size: 12px;
                width: 100%;
                margin-top: 20px;
            }
            th {
                text-align: left;
                font-style: italic;
                background-color: #e8eff4;
                color: #707070;
                padding: 3px 7px 2px 7px;
            }
            td {
                text-align: left;
                padding: 3px 7px 2px 7px;
                /* border-bottom: solid 1px blue; */
                width: inherit;
            }
			            
            .toc {
                border: none;
            }
            	
			.title {
				font-size: larger;
				font-weight: bold;
			}
			
            .section {
            	background: #e8eff4;
            	/* text-indent: 20px; */
            }
            
            .indent {
                /* text-indent: 20px; */
                border: solid 1px  #e9008f;
                margin: 0px;
                padding: 0px;
            }
            
            .metric {
                /* text-indent: 20px; */
                /* border: solid 1px green; */
                border: none;
                margin: 0px;
                padding: 0px;
            }
                        
            .relationship {
                /* text-indent: 10px; */
                /* border: solid 1px green; */
                border: none;
                margin: 0px;
                padding: 0px;
				width: 50%;
            }
			
			.relationship th {
				font-style: normal;
				background-color: #e9008f;
				color: #FFFFFF;
			}
            
            .expression {
            	font-style: italic;
            	color: #222222;
            }
        </style>
<body>
<%
	ListFolder lf = new util.ListFolder();
	lf.initMonitors();
%>
<a href="/remote/monitors/monitors.jsp">Home</a> (<%= lf.getPath() %>)
<table>
<%
	String path = request.getContextPath();
	if( request.getQueryString() != null){
		path += "/" + request.getQueryString();
	}
    List<File> files = lf.getFiles(path);
    for ( File f : files) {
        %>
        <tr>
        	<td><%= f.isDirectory() ? "Service Run" : "Report" %></td>
        	<td>
        	<a href=<%=  f.isDirectory() ? "/remote/monitors/monitors.jsp?" + f.getName(): 
        		"/netxforge/files/" + ( request.getQueryString() == null ? "" : request.getQueryString() + "/")  + f.getName() %>>
        		<%= f.getName() %>
        	</a></td>
        </tr>
        <%
    }   
%>
</table>
</body>
</html>