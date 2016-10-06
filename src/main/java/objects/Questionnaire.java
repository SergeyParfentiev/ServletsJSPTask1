package objects;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Questionnaire {

    private static Questionnaire instance;

    private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

    private final ConcurrentHashMap<String, Integer> vanillaQuestion = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> governorQuestion = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> galaxyQuestion = new ConcurrentHashMap<>();


    private Questionnaire() {
        fillStartingData();
    }

    public synchronized static Questionnaire getInstance() {
        if (instance == null) {
            instance = new Questionnaire();
            return instance;
        } else {
            return instance;
        }
    }

    private void fillStartingData() {
        fillBaseDataVanilla();
        fillBaseDataGovernor();
        fillBaseDataGalaxy();
    }

    public void addUser(String name, String surname, String age) {
        users.add(new User(name, surname, Integer.parseInt(age)));
    }

    public CopyOnWriteArrayList<User> getUsers() {
        return users;
    }

    public synchronized void addVanillaAnswer(String key) {
        vanillaQuestion.put(key, vanillaQuestion.get(key) + 1);
    }

    public synchronized void addGovernorAnswer(String key) {
        governorQuestion.put(key, governorQuestion.get(key) + 1);
    }

    public synchronized void addGalaxyAnswer(String key) {
        galaxyQuestion.put(key, galaxyQuestion.get(key) + 1);
    }

    public ConcurrentHashMap<String, Integer> getVanillaStatistics() {
        return vanillaQuestion;
    }

    public ConcurrentHashMap<String, Integer> getGovernorStatistics() {
        return governorQuestion;
    }

    public ConcurrentHashMap<String, Integer> getGalaxyStatistics() {
        return galaxyQuestion;
    }

    private void fillBaseDataVanilla() {
        vanillaQuestion.put("fruit", 0);
        vanillaQuestion.put("stems", 0);
        vanillaQuestion.put("root", 0);
        vanillaQuestion.put("leaves", 0);
    }

    private void fillBaseDataGovernor() {
        governorQuestion.put("satrap", 0);
        governorQuestion.put("despot", 0);
        governorQuestion.put("tyrant", 0);
        governorQuestion.put("tycoon", 0);
    }

    private void fillBaseDataGalaxy() {
        galaxyQuestion.put("magellanic Clouds", 0);
        galaxyQuestion.put("andromeda Nebula", 0);
        galaxyQuestion.put("centaurus A", 0);
        galaxyQuestion.put("milky Way", 0);
    }
}
