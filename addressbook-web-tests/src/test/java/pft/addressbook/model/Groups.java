package pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus-1 on 26.01.2017.
 */
public class Groups extends ForwardingSet <GroupData> {
  private  Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  @Override

  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded (GroupData group) {
    Groups groups = new Groups(this); // строим копию сущетвующего объекта
    groups.add(group); // добавляем к копии новую группу
    return groups;
  }

  public Groups withOut (GroupData group) {
    Groups groups = new Groups(this); // строим копию сущетвующего объекта
    groups.remove(group);
    return groups;
  }
}
