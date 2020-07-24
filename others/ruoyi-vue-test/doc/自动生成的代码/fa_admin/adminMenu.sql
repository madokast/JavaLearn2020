-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员', '3', '1', 'admin', 'wangyuan/admin/index', 1, 'C', '0', '0', 'wangyuan:admin:list', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '管理员菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员查询', @parentId, '1',  '#', '', 1,  'F', '0',  '0', 'wangyuan:admin:query',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员新增', @parentId, '2',  '#', '', 1,  'F', '0',  '0', 'wangyuan:admin:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员修改', @parentId, '3',  '#', '', 1,  'F', '0',  '0', 'wangyuan:admin:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员删除', @parentId, '4',  '#', '', 1,  'F', '0',  '0', 'wangyuan:admin:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('管理员导出', @parentId, '5',  '#', '', 1,  'F', '0',  '0', 'wangyuan:admin:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');