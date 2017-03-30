package com.lundellnet.toolbox.obj.data_access;

import java.util.function.Function;

public interface CrawlStep <I, O> {
  Function<I, O> progress();
}
