package com.lundellnet.toolbox.obj.elements;

import com.lundellnet.toolbox.obj.annotations.DataMapping;
import com.lundellnet.toolbox.obj.data_access.configs.DataAccessConf;
import com.lundellnet.toolbox.obj.data_access.configurables.ConfigurableFieldAccess;

public interface DataMappedElement <I, O, C extends DataAccessConf<I, O>>
		extends ConfigurableFieldAccess<I, O, C>
{
    default DataMapping getMapping() {
	DataMapping map = getField().getAnnotation(DataMapping.class);
	
	if (map == null) {
		throw new DataPointElementException("No " + DataMapping.class.getName() + " associated with this Element.");
	}
	
	return map;
    }
}
