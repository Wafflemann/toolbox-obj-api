/*
 Copyright 2017 Appropriate Technologies LLC.

 This file is part of toolbox-obj, a component of the Lundellnet Java Toolbox.

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
package com.lundellnet.toolbox.obj.collectors;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import com.lundellnet.toolbox.obj.collections.DataElementCollection;
import com.lundellnet.toolbox.obj.parsers.Parser;

@FunctionalInterface
public interface ParsingCollector <T, P extends Parser<T, C, ?, R>, C extends DataElementCollection<R, ?>, R>
	extends CoreCollector<T, P, C, R> 
{
    @Override
    default BiConsumer<P, T> accumulator() {
	return (p, t) -> p.accept(t);
    }
	
    @Override
    default BinaryOperator<P> combiner() {
	return (p1, p2) -> p1;
    }
	
    @Override
    default Function<P, R> finisher() {
	return (p) -> p.transform();
    }
}
