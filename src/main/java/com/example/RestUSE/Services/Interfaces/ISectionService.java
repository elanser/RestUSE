package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Entity.Section;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ISectionService {
    CompletableFuture<List<Section>> getSectionList();
}
