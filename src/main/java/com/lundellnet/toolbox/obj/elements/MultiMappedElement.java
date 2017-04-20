/*
 Copyright 2017 Appropriate Technologies LLC.

 This file is part of toolbox-obj-api, a component of the Lundellnet Java Toolbox.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.lundellnet.toolbox.obj.elements;

import com.lundellnet.toolbox.obj.annotations.DataMapping;
import com.lundellnet.toolbox.obj.annotations.DataMappings;
import com.lundellnet.toolbox.obj.data_access.configs.DataAccessConf;
import com.lundellnet.toolbox.obj.data_access.configurables.ConfigurableFieldAccess;

public interface MultiMappedElement <I, O, C extends DataAccessConf<I, O>>
	extends ConfigurableFieldAccess<I, O, C>, AnnotatedElement<I, O, C>
{
    default DataMapping[] getMapping() {
	DataMapping[] map = getField().getAnnotation(DataMappings.class).value();
	
	if (map == null) {//TODO throw exception? maybe return null or have a property setting?
	    throw new DataPointElementException(
		    "No " + DataMappings.class.getName() + " associated with this Element.");
	}

	return map;
    }
}
