package telepads.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class telepad extends ModelBase
{
	//fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;

	public telepad()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-5F, 0F, -5F, 10, 1, 10);
		Shape1.setRotationPoint(0F, 22F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(-3F, 0F, 0F, 3, 1, 2);
		Shape2.setRotationPoint(-5F, 22F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, -0.2F, 0F, -0.4F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(-3F, 0F, -2F, 3, 1, 2);
		Shape3.setRotationPoint(-5F, 22F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0.2F, 0F, -0.4F);
		Shape4 = new ModelRenderer(this, 0, 11);
		Shape4.addBox(-5F, -0.5F, -5F, 10, 1, 10);
		Shape4.setRotationPoint(0F, 23F, 0F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0.8F, 0F);
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(0F, 0F, 0F, 3, 1, 2);
		Shape5.setRotationPoint(5F, 22F, 0F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, -0.2F, 0F, 0.4F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, -2F, 3, 1, 2);
		Shape6.setRotationPoint(5F, 22F, 0F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0.2F, 0F, 0.4F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(-2F, 0F, -3F, 2, 1, 3);
		Shape7.setRotationPoint(0F, 22F, -5F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0.4F, 0.1F, -0.2F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, -3F, 2, 1, 3);
		Shape8.setRotationPoint(0F, 22F, -5F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0.4F, -0.05F, 0.2F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(0F, 0F, 0F, 2, 1, 3);
		Shape9.setRotationPoint(0F, 22F, 5F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, -0.4F, 0.1F, 0.2F);
		Shape10 = new ModelRenderer(this, 0, 0);
		Shape10.addBox(-2F, 0F, 0F, 2, 1, 3);
		Shape10.setRotationPoint(0F, 22F, 5F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, -0.4F, -0.05F, -0.2F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}


	public void render (float f5){
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
