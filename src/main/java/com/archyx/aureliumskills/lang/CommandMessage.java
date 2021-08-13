package com.archyx.aureliumskills.lang;

import com.archyx.aureliumskills.commands.Command;

import java.util.Locale;

public enum CommandMessage implements MessageKey {

    PREFIX,
    ARMOR_MODIFIER_ADD_ADDED,
    ARMOR_MODIFIER_ADD_ALREADY_EXISTS(Command.ARMOR_MODIFIER_ADD, "already_exists"),
    ARMOR_MODIFIER_ADD_LORE,
    ARMOR_MODIFIER_ADD_LORE_SUBTRACT(Command.ARMOR_MODIFIER_ADD, "lore_subtract"),
    ARMOR_MODIFIER_REMOVE_DOES_NOT_EXIST(Command.ARMOR_MODIFIER_REMOVE, "does_not_exist"),
    ARMOR_MODIFIER_REMOVE_REMOVED,
    ARMOR_MODIFIER_LIST_HEADER,
    ARMOR_MODIFIER_LIST_ENTRY,
    ARMOR_MODIFIER_REMOVEALL_REMOVED,
    ARMOR_REQUIREMENT_ADD_ADDED,
    ARMOR_REQUIREMENT_ADD_ALREADY_EXISTS(Command.ARMOR_REQUIREMENT_ADD, "already_exists"),
    ARMOR_REQUIREMENT_ADD_LORE,
    ARMOR_REQUIREMENT_REMOVE_DOES_NOT_EXIST(Command.ARMOR_REQUIREMENT_REMOVE, "does_not_exist"),
    ARMOR_REQUIREMENT_REMOVE_REMOVED,
    ARMOR_REQUIREMENT_LIST_HEADER,
    ARMOR_REQUIREMENT_LIST_ENTRY,
    ARMOR_REQUIREMENT_REMOVEALL_REMOVED,
    ARMOR_REQUIREMENT_EQUIP,
    ARMOR_REQUIREMENT_ENTRY,
    BACKUP_LOAD_CONFIRM,
    BACKUP_LOAD_LOADING,
    BACKUP_LOAD_LOADED,
    BACKUP_LOAD_ERROR,
    BACKUP_LOAD_MUST_BE_YAML(Command.BACKUP_LOAD, "must_be_yaml"),
    BACKUP_LOAD_FILE_NOT_FOUND(Command.BACKUP_LOAD, "file_not_found"),
    BACKUP_SAVE_SAVING,
    BACKUP_SAVE_SAVED,
    BACKUP_SAVE_ERROR,
    CLAIMITEMS_NO_ITEMS(Command.CLAIMITEMS, "no_items"),
    ITEM_GIVE_SENDER,
    ITEM_GIVE_RECEIVER,
    ITEM_MODIFIER_ADD_ADDED,
    ITEM_MODIFIER_ADD_ALREADY_EXISTS(Command.ITEM_MODIFIER_ADD, "already_exists"),
    ITEM_MODIFIER_ADD_LORE,
    ITEM_MODIFIER_ADD_LORE_SUBTRACT(Command.ITEM_MODIFIER_ADD, "lore_subtract"),
    ITEM_MODIFIER_REMOVE_DOES_NOT_EXIST(Command.ITEM_MODIFIER_REMOVE, "does_not_exist"),
    ITEM_MODIFIER_REMOVE_REMOVED,
    ITEM_MODIFIER_LIST_HEADER,
    ITEM_MODIFIER_LIST_ENTRY,
    ITEM_MODIFIER_REMOVEALL_REMOVED,
    ITEM_REGISTER_REGISTERED,
    ITEM_REGISTER_ALREADY_REGISTERED(Command.ITEM_REGISTER, "already_registered"),
    ITEM_REGISTER_NO_SPACES(Command.ITEM_REGISTER, "no_spaces"),
    ITEM_REQUIREMENT_ADD_ADDED,
    ITEM_REQUIREMENT_ADD_ALREADY_EXISTS(Command.ITEM_REQUIREMENT_ADD, "already_exists"),
    ITEM_REQUIREMENT_ADD_LORE,
    ITEM_REQUIREMENT_REMOVE_DOES_NOT_EXIST(Command.ITEM_REQUIREMENT_REMOVE, "does_not_exist"),
    ITEM_REQUIREMENT_REMOVE_REMOVED,
    ITEM_REQUIREMENT_LIST_HEADER,
    ITEM_REQUIREMENT_LIST_ENTRY,
    ITEM_REQUIREMENT_REMOVEALL_REMOVED,
    ITEM_REQUIREMENT_USE,
    ITEM_REQUIREMENT_ENTRY,
    ITEM_UNREGISTER_UNREGISTERED,
    ITEM_UNREGISTER_NOT_REGISTERED(Command.ITEM_UNREGISTER, "not_registered"),
    LANG_SET,
    LANG_NOT_FOUND(Command.LANG, "not_found"),
    MANA_DISPLAY,
    MANA_DISPLAY_OTHER(Command.MANA, "display_other"),
    MANA_SET,
    MANA_ADD,
    MANA_REMOVE,
    MANA_AT_LEAST_ZERO(Command.MANA, "at_least_zero"),
    MANA_CONSOLE_SPECIFY_PLAYER(Command.MANA, "console_specify_player"),
    MODIFIER_ADD_ADDED,
    MODIFIER_ADD_ALREADY_EXISTS(Command.MODIFIER_ADD, "already_exists"),
    MODIFIER_REMOVE_NOT_FOUND(Command.MODIFIER_REMOVE, "not_found"),
    MODIFIER_REMOVE_REMOVED,
    MODIFIER_LIST_ALL_STATS_HEADER(Command.MODIFIER_LIST, "all_stats_header"),
    MODIFIER_LIST_ALL_STATS_ENTRY(Command.MODIFIER_LIST, "all_stats_entry"),
    MODIFIER_LIST_ONE_STAT_HEADER(Command.MODIFIER_LIST, "one_stat_header"),
    MODIFIER_LIST_ONE_STAT_ENTRY(Command.MODIFIER_LIST, "one_stat_entry"),
    MODIFIER_LIST_PLAYERS_ONLY(Command.MODIFIER_LIST, "players_only"),
    MODIFIER_REMOVEALL_REMOVED_ALL_STATS(Command.MODIFIER_REMOVEALL, "removed_all_stats"),
    MODIFIER_REMOVEALL_REMOVED_ONE_STAT(Command.MODIFIER_REMOVEALL, "removed_one_stat"),
    MODIFIER_REMOVEALL_PLAYERS_ONLY(Command.MODIFIER_REMOVEALL, "players_only"),
    NO_PROFILE("no_profile"),
    MULTIPLIER_LIST,
    MULTIPLIER_PLAYERS_ONLY(Command.MULTIPLIER, "players_only"),
    RANK_HEADER,
    RANK_POWER,
    RANK_ENTRY,
    RELOAD,
    SAVE_ALREADY_SAVING(Command.SAVE, "already_saving"),
    SAVE_MYSQL_NOT_ENABLED(Command.SAVE, "mysql_not_enabled"),
    SAVE_SAVED,
    SKILL_RESET_RESET_ALL(Command.SKILL_RESET, "reset_all"),
    SKILL_RESET_RESET_SKILL(Command.SKILL_RESET, "reset_skill"),
    SKILL_SETALL_AT_LEAST_ONE(Command.SKILL_SETALL, "at_least_one"),
    SKILL_SETALL_SET,
    SKILL_SETLEVEL_AT_LEAST_ONE(Command.SKILL_SETLEVEL, "at_least_one"),
    SKILL_SETLEVEL_SET,
    TOGGLE_ENABLED,
    TOGGLE_DISABLED,
    TOGGLE_NOT_ENABLED(Command.TOGGLE, "not_enabled"),
    TOP_POWER_ENTRY(Command.TOP, "power_entry"),
    TOP_POWER_HEADER(Command.TOP, "power_header"),
    TOP_POWER_HEADER_PAGE(Command.TOP, "power_header_page"),
    TOP_SKILL_HEADER(Command.TOP, "skill_header"),
    TOP_SKILL_HEADER_PAGE(Command.TOP, "skill_header_page"),
    TOP_SKILL_ENTRY(Command.TOP, "skill_entry"),
    TOP_USAGE,
    TOP_AVERAGE_HEADER(Command.TOP, "average_header"),
    TOP_AVERAGE_HEADER_PAGE(Command.TOP, "average_header_page"),
    TOP_AVERAGE_ENTRY(Command.TOP, "average_entry"),
    UPDATELEADERBOARDS_ALREADY_UPDATING(Command.UPDATELEADERBOARDS, "already_updating"),
    UPDATELEADERBOARDS_UPDATED,
    VERSION,
    XP_ADD,
    XP_SET,
    XP_REMOVE,
    UNKNOWN_SKILL("unknown_skill");

    private final String path;

    CommandMessage() {
        this.path = "commands." + this.name().toLowerCase(Locale.ENGLISH).replace("_", ".");
    }
    
    CommandMessage(Command command, String path) {
        this.path = "commands." + command.name().toLowerCase(Locale.ENGLISH).replace("_", ".") + "." + path;
    }

    CommandMessage(String path) {
        this.path = "commands." + path;
    }

    public String getPath() {
        return path;
    }

}
