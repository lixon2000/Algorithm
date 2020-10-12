package com.lx.compile;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

// 如果在处理注解期间对语法树进行了修改，就必须回到解析和填充符号表那一步重新来，直到没有注解处理器处理为止，这个循环称为一个Round
//可以用"*"表示支持所有Annotations
@SupportedAnnotationTypes("*")
// 只支持JDK 1.6的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {
	private NameChecker nameChecker;

	/**
	 * 初始化名称检查插件
	 */
	@Override
	public void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		nameChecker = new NameChecker(processingEnv);
	}

	/**
	 * 对输入的语法树的各个节点进行名称检查
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv){
		if(!roundEnv.processingOver()){
			for(Element element: roundEnv.getRootElements()){
				nameChecker.checkNames(element);
			}
		}
		return false;
	}
	
}

