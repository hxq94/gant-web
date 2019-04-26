package generator;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;

import java.util.ArrayList;
import java.util.List;

public class DaoPlugin
        extends BasePluginAdapter
{
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable)
    {
        if (!"true".equalsIgnoreCase(getProperties().getProperty("isCreate", "false"))) {
            return null;
        }
        List<GeneratedJavaFile> daoList = new ArrayList();

        String entityName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        String tableComment = entityName;

        String interfaceName = this.targetPackage + "." + entityName + "Dao";
        Interface interfaceClass = new Interface(interfaceName);
        interfaceClass.setVisibility(JavaVisibility.PUBLIC);
        interfaceClass.addImportedType(new FullyQualifiedJavaType(this.baseDao));
        interfaceClass.addImportedType(new FullyQualifiedJavaType(this.entityPackage + "." + entityName));
        interfaceClass.addSuperInterface(super.buildFullyQualifiedJavaType(this.baseDao, entityName));

        GeneratorUtil.fillJavaDocLine(interfaceClass, tableComment, ClassType.DAO);
        daoList.add(super.buildGeneratedJavaFile(interfaceClass));

        String implementsName = this.targetPackage + ".impl." + entityName + "DaoImpl";
        TopLevelClass implementsClass = new TopLevelClass(implementsName);
        implementsClass.setVisibility(JavaVisibility.PUBLIC);
        implementsClass.addImportedType(this.baseDaoImpl);
        implementsClass.addImportedType(this.entityPackage + "." + entityName);
        implementsClass.addImportedType("javax.annotation.Resource");
        implementsClass.addImportedType("org.springframework.stereotype.Repository");
        implementsClass.addImportedType(this.baseMapper);
        implementsClass.addImportedType(this.mapperPackage + "." + entityName + "Mapper");
        implementsClass.addImportedType(interfaceName);
        implementsClass.addSuperInterface(new FullyQualifiedJavaType(interfaceName));
        implementsClass.setSuperClass(super.buildFullyQualifiedJavaType(this.baseDaoImpl, entityName));

        GeneratorUtil.fillJavaDocLine(implementsClass, tableComment, ClassType.DAO);
        implementsClass.addAnnotation("@Repository");
        String filedName = toLowerFirstChar(entityName) + "Mapper";
        Field mapperField = new Field(filedName, new FullyQualifiedJavaType(this.mapperPackage + "." + entityName + "Mapper"));
        mapperField.setVisibility(JavaVisibility.PRIVATE);
        mapperField.addAnnotation("@Resource");
        mapperField.addJavaDocLine("");
        mapperField.addJavaDocLine("/**");
        mapperField.addJavaDocLine(" * " + tableComment + "Mapper");
        mapperField.addJavaDocLine(" */");
        implementsClass.addField(mapperField);

        Method getMapperMethod = new Method("getMapper");
        getMapperMethod.setVisibility(JavaVisibility.PROTECTED);
        getMapperMethod.setReturnType(super.buildFullyQualifiedJavaType(this.baseMapper, entityName));
        getMapperMethod.addBodyLine("return " + filedName + ";");
        getMapperMethod.addAnnotation("@Override");
        getMapperMethod.addJavaDocLine("/**");
        getMapperMethod.addJavaDocLine(" * Mapper初始化");
        getMapperMethod.addJavaDocLine(" *");
        getMapperMethod.addJavaDocLine(" * @return");
        getMapperMethod.addJavaDocLine(" */");
        implementsClass.addMethod(getMapperMethod);

        daoList.add(super.buildGeneratedJavaFile(implementsClass));

        return daoList;
    }
}
