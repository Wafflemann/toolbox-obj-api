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

import com.lundellnet.toolbox.api.data_access.annotations.MatrixComponent;
import com.lundellnet.toolbox.api.data_access.annotations.MatrixComponentAdapter;
import com.lundellnet.toolbox.api.data_access.annotations.MatrixComponentField;
import com.lundellnet.toolbox.api.data_access.annotations.MatrixComponentPoint;
import com.lundellnet.toolbox.obj.data_access.configs.DataAccessConf;
import com.lundellnet.toolbox.obj.data_access.configurables.ConfigurableFieldAccess;

public interface ComponentElement <I, O, C extends DataAccessConf<I, O>>
	extends ConfigurableFieldAccess<I, O, C>, AnnotatedElement<I, O, C>
{
	default MatrixComponent getComponent() {
		return getField().getAnnotation(MatrixComponent.class);
	}
	
	default MatrixComponentAdapter getComponentAdapter() {
		return getField().getAnnotation(MatrixComponentAdapter.class);
	}
	
	default MatrixComponentField getComponentField() {
		return getField().getAnnotation(MatrixComponentField.class);
	}
	
    default MatrixComponentPoint getComponentPoint() {
		return getField().getAnnotation(MatrixComponentPoint.class);
    }
}
