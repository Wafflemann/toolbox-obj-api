package com.lundellnet.toolbox.obj.elements;

import com.lundellnet.toolbox.obj.annotations.DataMapping;
import com.lundellnet.toolbox.obj.annotations.DataMappings;
import com.lundellnet.toolbox.obj.data_access.configs.DataAccessConf;
import com.lundellnet.toolbox.obj.data_access.configurables.ConfigurableFieldAccess;

public interface DataMappedElements <I, O, C extends DataAccessConf<I, O>>
		extends ConfigurableFieldAccess<I, O, C>
{
    default DataMapping[] getMapping() {
	DataMapping[] map = getField().getAnnotation(DataMappings.class).value();
	
	if (map == null) {
	    throw new DataPointElementException(
		    "No " + DataMappings.class.getName() + " associated with this Element.");
	}

	return map;
    }
}
