package study.java;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@AutoService(Processor.class)
public class MagicMojaProcessor extends AbstractProcessor {

    // 처리할 Annotation 정보
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new HashSet<>();
        annotations.add(Magic.class.getName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // Magic annotation 정보만 가져온다
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);

        for (Element element : elements) {
            if (element.getKind() != ElementKind.INTERFACE) {   // 컴파일중에 Interface가 아니면 에러
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation can not be used on : " + element.getSimpleName());
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing : " + element.getSimpleName());
            }
        }

        return true;
    }
}
