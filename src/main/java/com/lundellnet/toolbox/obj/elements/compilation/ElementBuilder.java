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
package com.lundellnet.toolbox.obj.elements.compilation;

import com.lundellnet.toolbox.Reflect;
import com.lundellnet.toolbox.obj.data_access.configs.DataAccessConf;
import com.lundellnet.toolbox.obj.data_access.configurables.ConfigurableDataAccess;

@FunctionalInterface
public interface ElementBuilder <C extends DataAccessConf<?, ?>, E extends ConfigurableDataAccess<?>> {
	@SuppressWarnings("unchecked")
	static <E extends ConfigurableDataAccess<?>, B extends ElementBuilder<?, E>> B getBuilder(Class<E> elementClass)
			{ return (B) Reflect.invokePublicMethod(Reflect.getPublicMethod("builder", elementClass), null); }
	
	E build(C elementConf);
}