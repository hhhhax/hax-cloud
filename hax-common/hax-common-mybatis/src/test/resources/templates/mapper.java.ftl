package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
@Mapper
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
