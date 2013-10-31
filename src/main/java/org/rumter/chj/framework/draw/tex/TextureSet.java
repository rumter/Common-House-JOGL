package org.rumter.chj.framework.draw.tex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Структура предназначена для хранения списков названий текстур
 * 
 * Используется при начальной подгрузке
 * 
 * @author ilya
 * 
 */
public class TextureSet {

	private Map<String, List<String>> fileMap;
	private String currFolder = null;
	private String globalFolder = "";

	public TextureSet() {
		fileMap = new HashMap<String, List<String>>();
	}

	public void globalFolder(String gfolder) {
		globalFolder = gfolder;
	}

	public void folder(String folder) {
		if (folder != null && fileMap.get(folder) == null) {
			fileMap.put(folder, new ArrayList<String>());
			currFolder = folder;
		}
	}

	public void add(String file) {
		if (currFolder != null) {
			fileMap.get(currFolder).add(file);
		}
	}

	public void add(String files[]) {
		if (currFolder != null) {
			for (String file : files) {
				fileMap.get(currFolder).add(file);
			}
		}
	}

	public String getGlobalFolder() {
		return globalFolder;
	}

	public Collection<String> getFolderList() {
		return fileMap.keySet();
	}

	public Collection<String> getFileList(String folder) {
		return fileMap.get(folder);
	}

}
