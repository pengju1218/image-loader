/**
 * Copyright 2012 Novoda Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.novoda.imageloader.core.model;

public class ImageTag {

    private String url;
    private int loadingResourceId;
    private int notFoundResourceId;
    private int height;
    private int width;
    private boolean useOnlyCache;
    private boolean saveThumbnail;

    public ImageTag(String url, int loadingResourceId, int notFoundResourceId, int width, int height) {
        this.url = url;
        this.loadingResourceId = loadingResourceId;
        this.notFoundResourceId = notFoundResourceId;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getNotFoundResourceId() {
        return notFoundResourceId;
    }

    public int getLoadingResourceId() {
        return loadingResourceId;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isUseOnlyCache() {
        return useOnlyCache;
    }

    public void setUseOnlyCache(boolean useOnlyCache) {
        this.useOnlyCache = useOnlyCache;
    }

    public boolean isSaveThumbnail() {
        return saveThumbnail;
    }

    public void setSaveThumbnail(boolean saveThumbnail) {
        this.saveThumbnail = saveThumbnail;
    }

}