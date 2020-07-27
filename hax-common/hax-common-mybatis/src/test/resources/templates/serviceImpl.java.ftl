package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${entity}Service;
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;


/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${entity}ServiceImpl extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${entity}Service {


}
