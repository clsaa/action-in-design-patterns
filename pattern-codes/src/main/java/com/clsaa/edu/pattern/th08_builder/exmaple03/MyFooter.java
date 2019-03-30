package com.clsaa.edu.pattern.th08_builder.exmaple03;

public class MyFooter {

	public String genHeader(ExportFooterModel efm){
		String str = "  <Footer>\n";
		str+="    <ExportUser>"+efm.getExportUser()+"</ExportUser>\n";
		str+="  </Footer>\n";
		str+="</Report>\n";
		return str;
	}
}